package com.example.task_management_system_api;

import com.example.task_management_system_api.model.Task;
import com.example.task_management_system_api.service.TaskService;
import com.example.task_management_system_api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class TaskTest {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    private Task task;

    @BeforeEach
    void setUp() {
        task = new Task();
        task.setName("Test Task");
        task.setDescription("Description of the test task");
    }

    @Test
    void contextLoads() {
        assertThat(taskService).isNotNull();
    }

    @Test
    void testCreateTask() {
        Task createdTask = taskService.createTask(task);
        assertThat(createdTask).isNotNull();
        assertThat(createdTask.getId()).isNotNull();
        assertThat(createdTask.getName()).isEqualTo(task.getName());
    }

    @Test
    void testGetTaskById() {
        Task createdTask = taskService.createTask(task);
        Task foundTask = taskService.getTaskById(createdTask.getId());
        assertThat(foundTask).isNotNull();
        assertThat(foundTask.getId()).isEqualTo(createdTask.getId());
    }

    @Test
    void testUpdateTask() {
        Task createdTask = taskService.createTask(task);
        createdTask.setName("Updated Task");
        Task updatedTask = taskService.updateTask(createdTask.getId(), createdTask);
        assertThat(updatedTask.getName()).isEqualTo("Updated Task");
    }

    @Test
    void testDeleteTask() {
        Task createdTask = taskService.createTask(task);
        boolean isDeleted = taskService.deleteTask(createdTask.getId());
        assertThat(isDeleted).isTrue();
        Task foundTask = taskService.getTaskById(createdTask.getId());
        assertThat(foundTask).isNull();
    }
}