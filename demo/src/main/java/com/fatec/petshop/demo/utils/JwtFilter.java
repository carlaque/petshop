package com.fatec.petshop.demo.utils;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.fatec.petshop.demo.domain.UserDetailServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component
public class JwtFilter extends GenericFilterBean {

    @Autowired
    UserDetailServiceImpl userDetailServiceImpl;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest reqhttp = (HttpServletRequest) request;
        System.out.printf("Filtro JWT Path ==>(%s) %n", reqhttp.getServletPath());
        if ("/login".equals(reqhttp.getServletPath())) {
            chain.doFilter(request, response);
        } else {
            String authHeader = reqhttp.getHeader("Authorization");
            if (authHeader != null) {
                String token = authHeader.substring(7);
                System.out.printf("Token ==>(%s) %n", token);
                String user = JwtUtil.getAuthentication(token);
                UsernamePasswordAuthenticationToken upAuth = new UsernamePasswordAuthenticationToken(user, null,
                        Collections.singletonList(new SimpleGrantedAuthority("USER")));
                if (upAuth != null) {
                    SecurityContextHolder.getContext().setAuthentication(upAuth);
                    chain.doFilter(request, response);
                }
            }
        }

    }
}
