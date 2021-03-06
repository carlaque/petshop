package com.fatec.petshop.demo.domain;

import com.fatec.petshop.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = usuarioRepositorio.findByUsername(username);
        if (u == null) {
            throw new UsernameNotFoundException("Usuario não encontrado");
        }
        UsuarioDetail userDetail = new UsuarioDetail(u);
        return userDetail;
    }
}

