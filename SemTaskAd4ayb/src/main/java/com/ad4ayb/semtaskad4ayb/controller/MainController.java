package com.ad4ayb.semtaskad4ayb.controller;
import com.ad4ayb.semtaskad4ayb.models.Task;
import com.ad4ayb.semtaskad4ayb.services.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {

  @Autowired
    private TaskService taskService;

  @GetMapping("/all")
  public String listAllPlanets(Model model){
      model.addAttribute("tasks", taskService.findAll());
      return "all";
  }
  
  @GetMapping("/new")
  public String readNew(@ModelAttribute("task") Task task){
      return "new";
  }
  
  @PostMapping("/new")
  public String addNew( @ModelAttribute("task") Task task){
      taskService.addTask(task);
      return "redirect:/all";
  }
  
  @PostMapping("/delete")
  public String remove( @ModelAttribute("task") Task task){
      taskService.deleteTask(task);
      return "redirect:/all";
  }
  
  @PostMapping("/update")
  public String showUpdate(@ModelAttribute("task") Task task){
      return "update";
  }

  @PostMapping("/updatepressed")
  public String saveUpdate(@ModelAttribute("task") Task task){
	  taskService.updateTask(task);
	  return "redirect:/all";
  }
  

}
