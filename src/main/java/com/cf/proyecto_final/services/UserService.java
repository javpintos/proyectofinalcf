package com.cf.proyecto_final.services;

import com.cf.proyecto_final.entities.User;
import com.cf.proyecto_final.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    // Crear un nuevo usuario
    public User createUser(User user) {
        return userRepository.save(user);
    }
    // Obtener un usuario por ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    // Obtener todos los usuarios
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    // Actualizar un usuario
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow();
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }
    // Eliminar un usuario
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
