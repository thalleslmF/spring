package com.example.demo.rest;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
@RequestMapping("api/project")
public class RestApiDemo {
	@Autowired
	ProjectService projectService;
	@PostMapping("api/project")
	public String createProject(@RequestParam(value = "id",required=true) String id) {
		return "hi";
	}
	
}
