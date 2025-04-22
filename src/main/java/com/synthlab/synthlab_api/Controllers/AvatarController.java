package com.synthlab.synthlab_api.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synthlab.synthlab_api.Entities.Avatar;
import com.synthlab.synthlab_api.Services.AvatarService;

@RestController
@CrossOrigin
@RequestMapping("avatars")
public class AvatarController {
    private final AvatarService avatarService;

    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    @GetMapping
    public List<Avatar> getAllAvatars() {
        return avatarService.getAllAvatars();
    }

    @GetMapping("/{id}")
    public Avatar getAvatarById(@PathVariable Long id) {
        return avatarService.getAvatarById(id);
    }
}
