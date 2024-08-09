package com.example.task_management_system_api.controller;

import com.example.task_management_system_api.service.TaskService;
import com.example.task_management_system_api.model.Task;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")

public class TaskController {
    @Autowired
    private TaskService taskService;
    @Operation(summary = "Cоздание задачи")
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return ResponseEntity.ok(taskService.createTask(task));
    }
    @GetMapping("/{id}")
    public ResponseEntity<com.example.task_management_system_api.model.Task> getTaskById(@PathVariable Long id){
        Task task = taskService.getTaskById(id);
        return task != null ? ResponseEntity.ok(task) : ResponseEntity.notFound().build();
    }
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok(taskService.getAllTasks());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task){
        Task updatedTask = taskService.updateTask(id,task);
        return updatedTask != null ? ResponseEntity.ok(updatedTask):ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        boolean idDeleted = taskService.deleteTask(id);
        return idDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
