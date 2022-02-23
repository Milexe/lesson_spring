package com.example.lessonspring.model;

import com.example.lessonspring.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class User {
    private long id;
    private String username;
    private List<Task> tasks;

    public static User toModel(UserEntity entity){
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setTasks(entity.getTasks().stream().map(Task::toModel).collect(Collectors.toList()));
        return model;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
