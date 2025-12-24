package com.ToList.management.Controller;

import com.ToList.management.DTO.*;
import com.ToList.management.Service.impl.TaskServiceImpl;
import com.ToList.management.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskServiceImpl service;

    public TaskController(TaskServiceImpl service){
        this.service = service;
    }

    //GET
    @GetMapping("/")
    public ResponseEntity<List> listAll(){
        List<TaskListDTO> list =  service.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> findById(@PathVariable Long id){
        TaskResponseDTO task =  service.findById(id);
        return ResponseEntity.ok(task);
    }
    @GetMapping("/completed")
    public ResponseEntity<List> listTaskCompleted(){
        List<TaskListDTO> list =  service.listTaskCompleted();
        return ResponseEntity.ok(list);
    }



    //PUT
    @PutMapping("/update/{id}")
    public ResponseEntity<TaskResponseDTO> update(@PathVariable Long id, @RequestBody TaskUpdateDTO dto){
        TaskResponseDTO dtoR = service.update(id, dto);
        return ResponseEntity.ok(dtoR);
    }
    @PutMapping("/update/completed/{id}")
    public ResponseEntity<TaskResponseDTO> completedTask(@PathVariable Long id, @RequestBody TaskStatusUpdateDTO dto){
        TaskResponseDTO dtoR = service.completeTask(id, dto);
        return ResponseEntity.ok(dtoR);
    }
    //POST
    @PostMapping("/criar")
    public ResponseEntity<TaskResponseDTO> create(@RequestBody TaskCreateDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    //Delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }





}
