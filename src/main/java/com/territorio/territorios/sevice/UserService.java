package com.territorio.territorios.sevice;

import com.territorio.territorios.dto.UserDTO;
import com.territorio.territorios.mapper.UserMapper;
import com.territorio.territorios.model.User;
import com.territorio.territorios.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.territorio.territorios.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserDTO create(UserDTO dto) {

        User user = userMapper.toEntity(dto);

        // Role
//        Role role = roleRepository.findById(dto.getRoleId())
//                .orElseThrow(() -> new NotFoundException("Role not found"));
//
//        user.setRole(role);

        // Password (ejemplo básico)
        user.setPassword(passwordEncoder.encode("123456"));
        user.setCreatedAt(LocalDate.now());

        return userMapper.toDto(userRepository.save(user));
    }

    public UserDTO getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));

        return userMapper.toDto(user);
    }

    public List<UserDTO> getAll() {
        return userRepository.findAllByDeletedAtIsNull()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));

        user.setDeletedAt(LocalDate.now());
        userRepository.save(user);
    }
}