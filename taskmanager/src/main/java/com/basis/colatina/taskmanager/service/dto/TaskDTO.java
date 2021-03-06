package com.basis.colatina.taskmanager.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class TaskDTO implements Serializable {

    private Integer id;
    private String title;
    private String description;
    private String type;
    private LocalDate expectedStartDate;
    private LocalDate expectedEndDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer statusId;
    private Integer ownerId;
    List<CommentDTO> comments;
    List<DocumentDTO> documents;

}
