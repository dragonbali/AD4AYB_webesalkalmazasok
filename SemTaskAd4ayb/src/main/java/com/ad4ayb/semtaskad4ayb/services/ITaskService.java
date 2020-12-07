package com.ad4ayb.semtaskad4ayb.services;

import java.util.List;

import com.ad4ayb.semtaskad4ayb.models.Task;

public interface ITaskService {
    public List<Task> findAll();

    public void addTask(Task task);
    public void updateTask(Task task);
    public void deleteTask(Task task);
}
