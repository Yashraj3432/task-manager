package com.yashraj.taskmanager.dto;

import com.yashraj.taskmanager.entity.Task;

public class UpdateStatusRequest {

    private Task.Status status;

    public Task.Status getStatus() {
        return status;
    }

    public void setStatus(Task.Status status) {
        this.status = status;
    }
}