package com.example.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Project;
import com.example.demo.rest.ProjectService;

@RestController

@RequestMapping("/project")
public class ProjectController {
	@Autowired
	ProjectService projectService;
	@PostMapping("")
	public ResponseEntity<?>  createNewProject(@Valid @RequestBody Project project,BindingResult result){
		if(result.hasErrors()) {
			return new ResponseEntity<String>("Erro ao validar", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		projectService.saveorUpdate(project);
		return new ResponseEntity<Project>(project,HttpStatus.CREATED);
	}
	@GetMapping("")
	public ResponseEntity<?> getProject(@RequestParam(value="ronaldo",required=false) int id){
		
		Project project = projectService.findById(id);
		return new ResponseEntity<Project>(project,HttpStatus.OK);
	}
	
	
}