package com.study.jpa.service;

import com.study.jpa.entity.User;
import com.study.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> selectAll() {
        return userRepository.findAll();
    }

}
