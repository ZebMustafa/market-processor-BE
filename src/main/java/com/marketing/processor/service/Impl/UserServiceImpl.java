package com.marketing.processor.service.Impl;

import com.marketing.processor.domain.entity.UserEntity;
import com.marketing.processor.repository.UserRepository;
import com.marketing.processor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public void createNewUser(Long userId){
        final UserEntity userEntitySource = new UserEntity();
        userEntitySource.setId(userId);
        userEntitySource.setName(userId+"-user");
        userRepository.save(userEntitySource);
    }

    @Override
    public Optional<UserEntity> findById(Long userId) {
        return userRepository.findById(userId);
    }
}
