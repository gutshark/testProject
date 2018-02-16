package com.pusong.study.h2Test.business.dto;

import com.pusong.study.h2Test.entity.UserEntity;

public class UserRequestDTO {
    private int id;
    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserEntity toEntity() {
        UserEntity entity = new UserEntity();

//        entity.setId(id);
        entity.setUserName(userName);

        return entity;
    }
}
