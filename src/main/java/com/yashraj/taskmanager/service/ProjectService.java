package com.yashraj.taskmanager.service;

import com.yashraj.taskmanager.entity.Project;
import com.yashraj.taskmanager.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public Project create(Project project) {
        return repository.save(project);
    }

    public List<Project> getAll() {
        return repository.findAll();
    }
}