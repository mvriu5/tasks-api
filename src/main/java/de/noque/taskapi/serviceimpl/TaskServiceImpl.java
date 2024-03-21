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
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
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
        Task taskDb = get(id);

        taskDb.setTask(task.getTask());
        taskDb.setTaskNumber(task.getTaskNumber());
        taskDb.setLabel(task.getLabel());
        taskDb.setPriority(task.getPriority());
        taskDb.setStatus(task.getStatus());

        return taskRepository.save(taskDb);
    }

    @Override
    public void delete(Long id) {
        get(id);
        taskRepository.deleteById(id);
    }
}
