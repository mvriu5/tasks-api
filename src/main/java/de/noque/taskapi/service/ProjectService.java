package de.noque.taskapi.service;

import de.noque.taskapi.model.Project;
import de.noque.taskapi.model.User;

import java.util.List;

public interface ProjectService {

    Project get(Long id);

    List<Project> getByCreator(Long id);

    List<Project> getProjectsByUser(User user);

    Project create(Project project);

    Project update(Long id, Project project);

    void delete(Long id);
}
