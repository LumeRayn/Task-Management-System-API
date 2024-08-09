package com.example.task_management_system_api;

import com.example.task_management_system_api.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaskManagementSystemApiApplicationTests {
    @Autowired
    private TaskService taskService;

    @Test
    void contextLoads() {
    }

}
