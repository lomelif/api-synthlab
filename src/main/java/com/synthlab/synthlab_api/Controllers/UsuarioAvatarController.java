package com.synthlab.synthlab_api.Controllers;

import com.synthlab.synthlab_api.Entities.UsuarioAvatar;
import com.synthlab.synthlab_api.Services.UsuarioAvatarService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/usuario-avatar")
public class UsuarioAvatarController {

    @Autowired
    private UsuarioAvatarService usuarioAvatarService;

    @PostMapping("/agregar")
    public UsuarioAvatar agregarUsuarioAvatar(@RequestBody Map<String, Long> request) {
        Long userId = request.get("id_usuario");
        Long avatarId = request.get("id_avatar");

        return usuarioAvatarService.agregarUsuarioAvatar(userId, avatarId);
    }
}
