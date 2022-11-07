package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.entity.Task;
import com.cydeo.entity.User;
import com.cydeo.enums.Status;

import java.util.List;

public interface TaskService {

    void save(TaskDTO taskDTO);
    void update(TaskDTO taskDTO);
    void delete(Long id);
    List<TaskDTO> listAllTasks();
    TaskDTO findById(Long id);
    int totalNonCompletedTask(String projectCode);
    int totalCompletedTask(String projectCode);

    void deleteByProject(ProjectDTO projectDTO);
    void completeByProject(ProjectDTO projectDTO);

    List<TaskDTO> listAllTasksByStatusIsNot(Status status);
    List<TaskDTO> listAllTasksByStatus(Status status);

    List<TaskDTO> listAllNonCompletedByAssignedEmployee(UserDTO assignedEmployee);

}
