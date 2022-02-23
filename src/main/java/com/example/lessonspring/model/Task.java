package com.example.lessonspring.model;

import com.example.lessonspring.entity.TasksEntity;

public class Task {
    private Long id;
    private String title;
    private boolean completed;

    public static Task toModel(TasksEntity task){
        Task model = new Task();
        model.setId(task.getId());
        model.setCompleted(task.isComplited());
        model.setTitle(task.getTitle());
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Task() {
    }
}
