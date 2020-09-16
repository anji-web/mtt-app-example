package com.example.mtt.repository;

import com.example.mtt.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UsersEntity, Integer> {
}
