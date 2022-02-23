package com.marketing.processor.service;

import com.marketing.processor.domain.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    void createNewUser(Long userId);

    Optional<UserEntity> findById(Long userId);
}
