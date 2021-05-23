package com.fatec.petshop.demo.service;

import com.fatec.petshop.demo.domain.Usuario;
import com.fatec.petshop.demo.domain.UsuarioDetail;
import com.fatec.petshop.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = usuarioRepository.findByUsername(username);
        if (u == null) {
            throw new UsernameNotFoundException("Usuario não encontrado");
        }
        UsuarioDetail userDetail = new UsuarioDetail(u);
        return userDetail;
    }
    
}
