package com.marketing.processor.service;

import com.marketing.processor.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    void createNewUser(Long userId);

    Optional<User> findById(Long userId);
}
