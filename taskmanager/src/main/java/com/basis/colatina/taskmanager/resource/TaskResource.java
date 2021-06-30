package com.basis.colatina.taskmanager.resource;

import com.basis.colatina.taskmanager.service.TaskService;
import com.basis.colatina.taskmanager.service.dto.TaskDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
@Slf4j
public class TaskResource {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskDTO>> findAll() {
        List<TaskDTO> tasks = taskService.findAll();
        log.info("Todas as tasks foram listadas!");
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> findById(@PathVariable("id") Integer id) {
        TaskDTO task = taskService.findOne(id);
        log.info("Task recuperada: {}", id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TaskDTO> create(@RequestBody TaskDTO taskDTO) {
        TaskDTO task = taskService.save(taskDTO);
        log.info("Task criada com sucesso: {}", task.getId());
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TaskDTO> update(@RequestBody TaskDTO taskDTO) {
        TaskDTO task = taskService.save(taskDTO);
        log.info("Task alterada com sucesso: {}", task.getId());
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        taskService.delete(id);
        log.info("Task excluida: {}", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
