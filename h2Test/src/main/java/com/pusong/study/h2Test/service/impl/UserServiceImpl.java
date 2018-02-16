package com.pusong.study.h2Test.service.impl;

import com.pusong.study.h2Test.entity.UserEntity;
import com.pusong.study.h2Test.exception.EntityIsNullException;
import com.pusong.study.h2Test.repository.UserRepository;
import com.pusong.study.h2Test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity get(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public UserEntity add(UserEntity userEntity) {
        if (userEntity == null) {
            throw new EntityIsNullException();
        }

        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        if (userEntity == null) {
            throw new EntityIsNullException();
        }

        return userRepository.save(userEntity);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }
}
