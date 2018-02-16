package com.pusong.study.h2Test.repository;

import com.pusong.study.h2Test.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
