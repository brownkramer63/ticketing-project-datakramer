package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Task;
import com.cydeo.enums.Status;
import com.cydeo.mapper.TaskMapper;
import com.cydeo.repository.TaskRepository;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public void save(TaskDTO taskDTO) {
        taskDTO.setTaskStatus(Status.OPEN);
        taskDTO.setAssignedDate(LocalDate.now());
        Task task = taskMapper.convertToEntity(taskDTO);
    }

    @Override
    public TaskDTO update(TaskDTO taskDTO) {
        Optional<Task> updatetask = taskRepository.findById(taskDTO.getId());
        Task convertedTask = taskMapper.convertToEntity(taskDTO);

        if (updatetask.isPresent()){
          convertedTask.setTaskStatus(updatetask.get().getTaskStatus());
          convertedTask.setAssignedDate(updatetask.get().getAssignedDate());
          taskRepository.save(convertedTask);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
    Optional<Task> task = taskRepository.findById(id);
   if (task.isPresent()){
       task.get().setIsDeleted(true);
       taskRepository.save(task.get());
       //using optional
   }
    }

    @Override
    public List<TaskDTO> listAllTasks() {
       List<Task> taskList= taskRepository.findAll();

        return taskList.stream().map(taskMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public TaskDTO findById(Long id) {

        Optional<Task> task = taskRepository.findById(id);

        if(task.isPresent()){
            return taskMapper.convertToDto(task.get());
        }
        return null;
    }


    @Override
    public int totalNonCompletedTask(String projectCode) {
        return taskRepository.totalNonCompletedTasks(projectCode);
    }

    @Override
    public int totalCompletedTask(String projectCode) {
        return taskRepository.totalCompletedTasks(projectCode);
    }
}
