package com.fatec.petshop.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id @GeneratedValue
    private long id;
    @Column
    private String username = "";
    @Column
    private String password = "";
    @Column
    private String role = "";

    public Usuario() {
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(length = 255)
    public String getPassword() {
        return password;
    }

    public void setSenha(String password) {
        this.password = password;
    }

    @Column(length = 25)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
