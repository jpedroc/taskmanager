package com.basis.colatina.taskmanager.resource;

import com.basis.colatina.taskmanager.service.CommentService;
import com.basis.colatina.taskmanager.service.OwnerService;
import com.basis.colatina.taskmanager.service.dto.CommentDTO;
import com.basis.colatina.taskmanager.service.dto.OwnerDTO;
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

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
@Slf4j
public class CommentResource {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentDTO> find(@RequestBody CommentDTO commentDTO) {
        CommentDTO comment = commentService.create(commentDTO);
        log.info("Comment criado com sucesso na tarefa: {}", comment.getTaskId());
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OwnerDTO> update(@PathVariable("id") Integer id) {
        commentService.delete(id);
        log.info("Comment deletado com sucesso: {}", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
