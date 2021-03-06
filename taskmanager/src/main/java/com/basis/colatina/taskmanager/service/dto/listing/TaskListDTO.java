package com.basis.colatina.taskmanager.service.dto.listing;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TaskListDTO implements Serializable {
    private Integer id;
    private String title;
    private String description;
    private String type;
    private String expectedStartDate;
    private String expectedEndDate;
    private String startDate;
    private String endDate;
    private String status;
    private String owner;
}
