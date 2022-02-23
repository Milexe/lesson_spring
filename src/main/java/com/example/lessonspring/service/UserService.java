package com.example.lessonspring.service;

import com.example.lessonspring.entity.UserEntity;
import com.example.lessonspring.exception.UserAlreadyExistException;
import com.example.lessonspring.exception.UserNotFoundException;
import com.example.lessonspring.model.User;
import com.example.lessonspring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if(userRepo.findByUsername(user.getUsername()) != null)
        {
            throw new UserAlreadyExistException("пользователь уже существует");
        }
        return userRepo.save(user);
    }
    public User getOne(Long id) throws UserNotFoundException {
        if(!userRepo.findById(id).isPresent())
            throw new UserNotFoundException("пользователь не найден");
        return User.toModel(userRepo.findById(id).get());
    }
    public Long deleteOne(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
