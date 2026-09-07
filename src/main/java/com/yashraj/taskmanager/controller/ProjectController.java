package com.yashraj.taskmanager.controller;

import com.yashraj.taskmanager.entity.Project;
import com.yashraj.taskmanager.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @PostMapping
    public Project create(@RequestBody Project project) {
        return service.create(project);
    }

    @GetMapping
    public List<Project> getAll() {
        return service.getAll();
    }
}