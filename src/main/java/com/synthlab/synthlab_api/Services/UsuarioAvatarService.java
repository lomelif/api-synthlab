package com.synthlab.synthlab_api.Services;

import com.synthlab.synthlab_api.Entities.Avatar;
import com.synthlab.synthlab_api.Entities.User;
import com.synthlab.synthlab_api.Entities.UsuarioAvatar;
import com.synthlab.synthlab_api.Repositories.AvatarRepository;
import com.synthlab.synthlab_api.Repositories.UserRepository;
import com.synthlab.synthlab_api.Repositories.UsuarioAvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioAvatarService {

    @Autowired
    private UsuarioAvatarRepository usuarioAvatarRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AvatarRepository avatarRepository;

    public UsuarioAvatar agregarUsuarioAvatar(Long userId, Long avatarId) {
        // Buscar usuario y avatar por ID
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Avatar avatar = avatarRepository.findById(avatarId).orElseThrow(() -> new RuntimeException("Avatar no encontrado"));

        // Crear la relación y guardarla
        UsuarioAvatar usuarioAvatar = new UsuarioAvatar(user, avatar);
        return usuarioAvatarRepository.save(usuarioAvatar);
    }
}
