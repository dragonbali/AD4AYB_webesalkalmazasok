package hu.ad4ayb.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hu.ad4ayb.logic.Listing;
import hu.ad4ayb.logic.Student;
import hu.ad4ayb.logic.Task;
import hu.ad4ayb.logic.Teacher;



@Configuration
public class DependencyConfig {

	@Bean
	public Teacher teacher() {
		return new Teacher();
	}	
	@Bean
	public Student student() {
		return new Student();
	}	
	@Bean
	public Task task() {
		return new Task();
	}
	@Bean 
	Listing listing() {
		return new Listing();
	}
}
