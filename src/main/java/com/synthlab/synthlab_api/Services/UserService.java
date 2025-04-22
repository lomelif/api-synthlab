package com.synthlab.synthlab_api.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.synthlab.synthlab_api.Entities.Avatar;
import com.synthlab.synthlab_api.Entities.User;
import com.synthlab.synthlab_api.Entities.UsuarioAvatar;
import com.synthlab.synthlab_api.Repositories.UserRepository;
import com.synthlab.synthlab_api.Repositories.UsuarioAvatarRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UsuarioAvatarRepository usuarioAvatarRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UsuarioAvatarRepository usuarioAvatarRepository) {
        this.userRepository = userRepository;
        this.usuarioAvatarRepository = usuarioAvatarRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    public Avatar getAvatarByUserId(Long userId) {
        Optional<UsuarioAvatar> usuarioAvatarOptional = usuarioAvatarRepository.findByUsuarioId(userId);

        if (usuarioAvatarOptional.isPresent()) {
            return usuarioAvatarOptional.get().getAvatar();
        } else {
            return null;
        }
    }

    public User getUserByCorreo(String correo) {
        Optional<User> userOptional = userRepository.findByCorreo(correo);
        return userOptional.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);

        user.setNombre(userDetails.getNombre());
        user.setApellidoPaterno(userDetails.getApellidoPaterno());
        user.setApellidoMaterno(userDetails.getApellidoMaterno());
        user.setCorreo(userDetails.getCorreo());
        
        if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        }
        
        user.setFechaNacimiento(userDetails.getFechaNacimiento());
        user.setCreatedAt(userDetails.getCreatedAt());

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}
