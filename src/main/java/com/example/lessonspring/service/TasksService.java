package com.example.lessonspring.service;

import com.example.lessonspring.entity.TasksEntity;
import com.example.lessonspring.entity.UserEntity;
import com.example.lessonspring.exception.UserAlreadyExistException;
import com.example.lessonspring.model.Task;
import com.example.lessonspring.repository.TasksRepo;
import com.example.lessonspring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TasksService {
    @Autowired
    private TasksRepo tasksRepo;
    @Autowired
    private UserRepo userRepo;

    public Task createTask(TasksEntity task, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        task.setUser(user);
        return Task.toModel(tasksRepo.save(task));
    }
    public Task completeTask(Long id){
        TasksEntity task = tasksRepo.findById(id).get();
        task.setComplited(!task.isComplited());
        return Task.toModel(tasksRepo.save(task));
    }
}
