package com.ad4ayb.semtaskad4ayb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ad4ayb.semtaskad4ayb.models.Task;


import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {

    List<Task> findByLesson(String lesson);

}