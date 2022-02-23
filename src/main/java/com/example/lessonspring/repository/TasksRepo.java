package com.example.lessonspring.repository;

import com.example.lessonspring.entity.TasksEntity;
import org.springframework.data.repository.CrudRepository;

public interface TasksRepo extends CrudRepository<TasksEntity, Long> {
}
