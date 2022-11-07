package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Task;

import java.util.List;

public interface TaskService {

    void save(TaskDTO taskDTO);
    TaskDTO update(TaskDTO taskDTO);
    void delete(Long id);
    List<TaskDTO> listAllTasks();
    TaskDTO findById(Long id);
    int totalNonCompletedTask(String projectCode);
    int totalCompletedTask(String projectCode);

    void deleteByProject(ProjectDTO projectDTO);

}
