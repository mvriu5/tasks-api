package de.noque.taskapi.repository;

import de.noque.taskapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findByTaskNumber(String taskNumber);

    Optional<List<Task>> findAllByProjectId(Long projectId);

    Optional<List<Task>> findAllByUserId(Long userId);



}
