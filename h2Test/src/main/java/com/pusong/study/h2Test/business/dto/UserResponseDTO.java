package com.pusong.study.h2Test.business.dto;

import com.pusong.study.h2Test.entity.UserEntity;

public class UserResponseDTO {
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

    public UserResponseDTO() {
    }

    public UserResponseDTO(UserEntity entity) {
        this.id = entity.getId();
        this.userName = entity.getUserName();
    }
}
