package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.entity.UserEntity;
import org.acme.model.UserDTO;
import org.acme.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UserService {

        @Inject
        UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.listAll().stream().map(user -> {
            UserDTO dto = new UserDTO();
            dto.name = user.name;
            dto.email = user.email;
            return dto;
        }).collect(Collectors.toList());
    }

        @Transactional
        public void addUser(UserDTO userDTO) {
            UserEntity user = new UserEntity();
            user.name = userDTO.name;
            user.email = userDTO.email;
            userRepository.persist(user);
        }
    }

