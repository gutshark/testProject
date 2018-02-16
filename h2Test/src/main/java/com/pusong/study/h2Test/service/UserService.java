package com.pusong.study.h2Test.service;

import com.pusong.study.h2Test.entity.UserEntity;

public interface UserService {
    UserEntity get(int id);

    UserEntity add(UserEntity userEntity);

    UserEntity update(UserEntity userEntity);

    void delete(int id);
}
