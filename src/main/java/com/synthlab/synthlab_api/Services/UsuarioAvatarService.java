package com.synthlab.synthlab_api.Services;

import com.synthlab.synthlab_api.Entities.Avatar;
import com.synthlab.synthlab_api.Entities.User;
import com.synthlab.synthlab_api.Entities.UsuarioAvatar;
import com.synthlab.synthlab_api.Repositories.UsuarioAvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioAvatarService {

    @Autowired
    private UsuarioAvatarRepository usuarioAvatarRepository;

    public UsuarioAvatar agregarUsuarioAvatar(User user, Avatar avatar) {
        UsuarioAvatar usuarioAvatar = new UsuarioAvatar(user, avatar);
        return usuarioAvatarRepository.save(usuarioAvatar);
    }
}
