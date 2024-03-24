package de.noque.taskapi.controller;

import de.noque.taskapi.model.Project;
import de.noque.taskapi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/api/project")
@RestController
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    public Project getProject(@PathVariable("id") Long id) {
        return projectService.get(id);
    }

    @GetMapping("/user/{userId}")
    public Project getProjectByUser(@PathVariable("userId") Long userId) {
        return projectService.get(userId);
    }

    @PostMapping("/create")
    public Project createProject(@RequestBody Project project) {
        return projectService.create(project);
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable("id") Long id, @RequestBody Project project) {
        return projectService.update(id, project);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable("id") Long id) {
        projectService.delete(id);
    }

}
