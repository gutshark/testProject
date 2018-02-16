package com.pusong.study.h2Test.business.impl;

import com.pusong.study.h2Test.business.UserBusiness;
import com.pusong.study.h2Test.business.dto.UserRequestDTO;
import com.pusong.study.h2Test.business.dto.UserResponseDTO;
import com.pusong.study.h2Test.entity.UserEntity;
import com.pusong.study.h2Test.exception.EntityNotExistsException;
import com.pusong.study.h2Test.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessImpl implements UserBusiness {

    @Autowired
    private UserService userService;

    @Override
    public UserResponseDTO get(int id) {
        return new UserResponseDTO(userService.get(id));
    }

    @Override
    public UserResponseDTO add(UserRequestDTO request) {
        return new UserResponseDTO(
                userService.add(request.toEntity()));
    }

    @Override
    public UserResponseDTO update(UserRequestDTO requestDTO) {
        UserEntity entity = userService.get(requestDTO.getId());
        if (entity == null) {
            throw new EntityNotExistsException();
        }

        BeanUtils.copyProperties(requestDTO, entity);

        return new UserResponseDTO(
                userService.update(entity));
    }

    @Override
    public void delete(int id) {
        UserEntity entity = userService.get(id);
        if (entity == null) {
            throw new EntityNotExistsException();
        }

        userService.delete(id);
    }
}
