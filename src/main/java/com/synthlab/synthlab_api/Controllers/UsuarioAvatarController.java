package com.synthlab.synthlab_api.Controllers;

import com.synthlab.synthlab_api.Entities.Avatar;
import com.synthlab.synthlab_api.Entities.User;
import com.synthlab.synthlab_api.Entities.UsuarioAvatar;
import com.synthlab.synthlab_api.Services.UsuarioAvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/usuario-avatar")
public class UsuarioAvatarController {

    @Autowired
    private UsuarioAvatarService usuarioAvatarService;

    @PostMapping("/agregar")
    public UsuarioAvatar agregarUsuarioAvatar(@RequestParam User user, @RequestParam Avatar avatar) {
        return usuarioAvatarService.agregarUsuarioAvatar(user, avatar);
    }
}
