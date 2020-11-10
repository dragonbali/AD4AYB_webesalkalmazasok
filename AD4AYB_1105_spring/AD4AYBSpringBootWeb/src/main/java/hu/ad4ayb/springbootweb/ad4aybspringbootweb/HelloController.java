package hu.ad4ayb.springbootweb.ad4aybspringbootweb;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class HelloController {

	@GetMapping("/")
	public String indexGet() {
		return "Hello Spring Boot web world!";
	}
	
	@GetMapping(value="/hello/{nev}")
	public String ad4aybHelloGet(@PathVariable String nev){
		return "Hello " + nev +"!";
	}
	
	@GetMapping(value = "/add/{a}/{b}")
	public String addGet(@PathVariable int a, @PathVariable int b) {
		return (a + "+" + b + " = " + (a + b));
	}
	
	@PostMapping(path = "/post")
	public String indexPost() {
		return "Hello Spring Boot web world! (Post)";
	}
	
	@PostMapping(path = "/namepost/{name}")
	public String ad4aybHelloPost(@PathVariable String name) {
		return ("Hello, " + name);
	}
	
	@PostMapping(path = "/addpost/{a}/{b}")
	public String addPost(@PathVariable int a, @PathVariable int b) {
		return (a + "+" + b + " = " + (a + b));
	}
	
	@GetMapping(value = "/weblap")
	public ModelAndView getRoot() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
}