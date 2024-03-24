package de.noque.taskapi.serviceimpl;

import de.noque.taskapi.exception.ProjectNotFoundException;
import de.noque.taskapi.model.Project;
import de.noque.taskapi.model.User;
import de.noque.taskapi.repository.ProjectRepository;
import de.noque.taskapi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project get(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));
    }

    @Override
    public List<Project> getByParentUser(Long parentUserId) {
        return projectRepository.findByParentUserId(parentUserId).orElseThrow(() -> new ProjectNotFoundException(parentUserId, new User()));
    }

    @Override
    public Project create(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project update(Long id, Project project) {
        Project projectDb = get(id);

        projectDb.setName(project.getName());
        projectDb.setParentUserId(project.getParentUserId());
        projectDb.setDescription(project.getDescription());
        projectDb.setTimeCreated(project.getTimeCreated());

        return projectRepository.save(projectDb);
    }

    @Override
    public void delete(Long id) {
        get(id);
        projectRepository.deleteById(id);
    }
}
