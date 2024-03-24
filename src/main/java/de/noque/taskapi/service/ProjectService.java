package de.noque.taskapi.service;

import de.noque.taskapi.model.Project;

import java.util.List;

public interface ProjectService {

    Project get(Long id);

    List<Project> getByUser(Long id);

    Project create(Project project);

    Project update(Long id, Project project);

    void delete(Long id);
}
