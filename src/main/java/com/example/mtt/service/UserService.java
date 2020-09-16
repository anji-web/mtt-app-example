package com.example.mtt.service;

import com.example.mtt.entity.UsersEntity;
import com.example.mtt.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UsersEntity saveUser(UsersEntity usersEntity){
        return userRepo.save(usersEntity);
    }



}
