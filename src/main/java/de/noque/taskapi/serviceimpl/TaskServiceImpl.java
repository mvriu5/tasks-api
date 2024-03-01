package de.noque.taskapi.serviceimpl;

import de.noque.taskapi.exception.TaskNotFoundException;
import de.noque.taskapi.model.Task;
import de.noque.taskapi.repository.TaskRepository;
import de.noque.taskapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task get(Long id) {
        Optional<Task> task = taskRepository.findById(id);

        if (task.isEmpty()) throw new TaskNotFoundException(id);

        return task.get();
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task update(Long id, Task task) {
        Optional<Task> taskDb = taskRepository.findById(id);

        if (taskDb.isEmpty()) throw new TaskNotFoundException(id);

        taskDb.get().setTask(task.getTask());
        taskDb.get().setTaskNumber(task.getTaskNumber());
        taskDb.get().setLabel(task.getLabel());
        taskDb.get().setPriority(task.getPriority());
        taskDb.get().setStatus(task.getStatus());

        return taskRepository.save(taskDb.get());
    }

    @Override
    public void delete(Long id) {
        Optional<Task> task = taskRepository.findById(id);

        if (task.isEmpty()) throw new TaskNotFoundException(id);

        taskRepository.deleteById(id);
    }
}
