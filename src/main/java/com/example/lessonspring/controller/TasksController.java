package com.example.lessonspring.controller;

import com.example.lessonspring.entity.TasksEntity;
import com.example.lessonspring.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    @Autowired
    TasksService tasksService;

    @PostMapping("")
    public ResponseEntity createTask(@RequestBody TasksEntity entity, @RequestParam Long userId)
    {
        try {
            return ResponseEntity.ok(tasksService.createTask(entity, userId));
        } catch (Exception e)
        {
            return ResponseEntity.badRequest().body("произошла ошибка");
        }
    }
    @PutMapping("")
    public ResponseEntity completeTask(@RequestParam Long Id)
    {
        try {
            return ResponseEntity.ok(tasksService.completeTask(Id));

        } catch (Exception e)
        {
            return ResponseEntity.badRequest().body("произошла ошибка");
        }
    }
}
