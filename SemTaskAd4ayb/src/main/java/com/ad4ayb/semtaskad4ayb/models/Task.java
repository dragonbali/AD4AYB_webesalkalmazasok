package com.ad4ayb.semtaskad4ayb.models;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Entity
@Data
@Table(name = "TASK")
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String lesson;
    private String todo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
  
}