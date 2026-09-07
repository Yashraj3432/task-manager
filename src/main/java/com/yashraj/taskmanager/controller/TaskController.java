package com.yashraj.taskmanager.controller;

import com.yashraj.taskmanager.dto.UpdateStatusRequest;
import com.yashraj.taskmanager.entity.Task;
import com.yashraj.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    // Create Task
    @PostMapping("/{projectId}")
    public Task createTask(
            @PathVariable Long projectId,
            @RequestBody Task task) {

        return service.createTask(projectId, task);
    }

    @PatchMapping("/{taskId}/status")
    public Task updateStatus(
            @PathVariable Long taskId,
            @RequestBody UpdateStatusRequest request) {

        return service.updateStatus(taskId, request.getStatus());
    }

    // Get Tasks by Project
    @GetMapping("/project/{projectId}")
    public List<Task> getTasksByProject(
            @PathVariable Long projectId) {

        return service.getTasksByProject(projectId);
    }
}