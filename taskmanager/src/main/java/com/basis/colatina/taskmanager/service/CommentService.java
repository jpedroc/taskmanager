package com.basis.colatina.taskmanager.service;

import com.basis.colatina.taskmanager.domain.Comment;
import com.basis.colatina.taskmanager.domain.Owner;
import com.basis.colatina.taskmanager.repository.CommentRepository;
import com.basis.colatina.taskmanager.repository.OwnerRepository;
import com.basis.colatina.taskmanager.service.dto.CommentDTO;
import com.basis.colatina.taskmanager.service.dto.OwnerDTO;
import com.basis.colatina.taskmanager.service.event.CommentEvent;
import com.basis.colatina.taskmanager.service.exception.BadRequestAlertException;
import com.basis.colatina.taskmanager.service.mapper.CommentMapper;
import com.basis.colatina.taskmanager.service.mapper.OwnerMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.util.Strings;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final ApplicationEventPublisher applicationEventPublisher;

    public CommentDTO create(CommentDTO commentDTO){
        if(StringUtils.isBlank(commentDTO.getDescription())) {
            throw new BadRequestAlertException("Comment is not empty");
        }

        Comment save = commentRepository.save(commentMapper.toEntity(commentDTO));
        applicationEventPublisher.publishEvent(new CommentEvent(save.getId()));
        return commentMapper.toDto(save);
    }

    public void delete(Integer id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new BadRequestAlertException("Comment not found!"));

        commentRepository.delete(comment);
    }

    public List<CommentDTO> findAllByTask(Integer taskId) {
        return commentMapper.toDto(commentRepository.findAllByTaskId(taskId));
    }

}
