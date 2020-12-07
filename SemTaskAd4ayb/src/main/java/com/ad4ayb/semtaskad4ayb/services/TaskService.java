package com.ad4ayb.semtaskad4ayb.services;

import com.ad4ayb.semtaskad4ayb.models.Task;
import com.ad4ayb.semtaskad4ayb.repositories.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService{

	@Autowired
    private TaskRepository repository;

    public List<Task> findAll(){
        return (List<Task>) repository.findAll();
    }

    public void addTask(Task task){
        repository.save(task);
    }

    public void updateTask(Task task){
        repository.save(task);
    }

    public void deleteTask(Task task){
        repository.delete(task);
    }
}
