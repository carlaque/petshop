package com.fatec.petshop.demo.service;

import com.fatec.petshop.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    // @Override
    // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //     Usuario u = usuarioRepositorio.findByUsuario(username);
    //     if (u == null) {
    //         throw new UsernameNotFoundException("Usuario não encontrado");
    //     }
    //     UsuarioDetail userDetail = new UsuarioDetail(u);
    //     return userDetail;
    // }
    
}
