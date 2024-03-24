package de.noque.taskapi.controller;

import de.noque.taskapi.model.Task;
import de.noque.taskapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(path = "/api/task")
@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable("id") Long id) {
        return taskService.get(id);
    }

    @GetMapping("/{taskNumber}")
    public Task getTask(@PathVariable("taskNumber") String taskNumber) {
        return taskService.get(taskNumber);
    }

    @GetMapping("/project/{projectId}")
    public List<Task> getTaskByProject(@PathVariable("projectId") Long projectId) {
        return taskService.getByProject(projectId);
    }

    @GetMapping("/user/{userId}")
    public List<Task> getTaskByUser(@PathVariable("userId") Long userId) {
        return taskService.getByUser(userId);
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
        return taskService.create(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable("id") Long id, @RequestBody Task task) {
        return taskService.update(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        taskService.delete(id);
    }
}
