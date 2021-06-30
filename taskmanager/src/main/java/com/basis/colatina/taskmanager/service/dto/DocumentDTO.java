package com.basis.colatina.taskmanager.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DocumentDTO implements Serializable {
    private Integer id;
    private String uuid;
    private String title;
    private String file;
    private String length;
    private String type;
    private Integer taskId;
}
