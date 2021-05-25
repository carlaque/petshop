package com.fatec.petshop.demo.config;

import com.fatec.petshop.demo.service.UsuarioService;
import com.fatec.petshop.demo.utils.JwtFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtFilter jwtFilter;

    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        try {
            auth.userDetailsService(usuarioService).passwordEncoder(getPasswordEncoder());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers("/senha/**").anonymous()
            .antMatchers("/login/**").anonymous()
            .antMatchers("/alunos/**").hasAnyAuthority("USER", "ADMIN")
            .antMatchers("/aluno/add/**").hasAuthority("ADMIN")
            .antMatchers("/**").denyAll()
            .and()
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            .sessionManagement()
            .and()
            .csrf().disable()
            .formLogin().disable();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
