package com.pusong.study.h2Test.business;

import com.pusong.study.h2Test.business.dto.UserRequestDTO;
import com.pusong.study.h2Test.business.dto.UserResponseDTO;

public interface UserBusiness {
    UserResponseDTO get(int id);

    UserResponseDTO add(UserRequestDTO request);

    UserResponseDTO update(UserRequestDTO requestDTO);

    void delete(int id);
}
