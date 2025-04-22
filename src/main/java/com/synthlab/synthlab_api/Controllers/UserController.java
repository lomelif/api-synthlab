package com.synthlab.synthlab_api.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.synthlab.synthlab_api.DTOs.UserInfoDTO;
import com.synthlab.synthlab_api.Entities.Avatar;
import com.synthlab.synthlab_api.Entities.User;
import com.synthlab.synthlab_api.Services.UserService;

@RestController
@CrossOrigin
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
        public UserInfoDTO getUserByCorreo(@RequestParam String correo) {

            User user = userService.getUserByCorreo(correo);
            Avatar avatar = userService.getAvatarByUserId(user.getId());
            
            return new UserInfoDTO(
                user.getId(), 
                user.getNombre(), 
                user.getApellidoPaterno(),
                user.getApellidoMaterno(),
                user.getCorreo(), 
                user.getFechaNacimiento(),
                avatar != null ? avatar.getImg() : null
            );
    }

}
