package com.fatec.petshop.demo.controller;

import com.fatec.petshop.demo.domain.UsuarioCredential;
import com.fatec.petshop.demo.service.UsuarioService;
import com.fatec.petshop.demo.utils.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    PasswordEncoder passwordEncoder;

    // @Autowired
    // userDetailServiceImpl userDetailServiceImpl;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping(value = "/senha/{senha}")
    public String codificaSenha(@PathVariable("senha") String senha) {
        String senhaCrypto = passwordEncoder.encode(senha);
        return senhaCrypto;
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody UsuarioCredential usuarioCredenciais) {
        UserDetails ud = usuarioService.loadUserByUsername(usuarioCredenciais.getUsername());
        if (ud != null && passwordEncoder.matches(ud.getPassword(), usuarioCredenciais.getPassword())) {

            return "{\"token\":\"" + JwtUtil.generateToken(ud.getUsername()) + "\"}";
        } else {
            return "{\"erro\":\"Usuário ou senha inválidos\"}";
        }
    }
}