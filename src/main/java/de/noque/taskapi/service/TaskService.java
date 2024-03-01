package de.noque.taskapi.service;

import de.noque.taskapi.model.Task;

import java.util.List;

public interface TaskService {

    Task get(Long id);

    List<Task> getAll();

    Task create(Task task);

    Task update(Long id, Task task);

    void delete(Long id);
}
