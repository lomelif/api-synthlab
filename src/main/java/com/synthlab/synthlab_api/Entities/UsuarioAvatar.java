package com.synthlab.synthlab_api.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario_avatar")
public class UsuarioAvatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private User usuario;

    @ManyToOne
    @JoinColumn(name = "id_avatar", nullable = false)
    private Avatar avatar;

    public UsuarioAvatar() {
    }

    public UsuarioAvatar(User usuario, Avatar avatar) {
        this.usuario = usuario;
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }
}
