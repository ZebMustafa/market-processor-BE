package com.marketing.processor.service.Impl;

import com.marketing.processor.domain.entity.User;
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
        final User userSource = new User();
        userSource.setId(userId);
        userSource.setName(userId+"-user");
        userRepository.save(userSource);
    }

    @Override
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }
}
