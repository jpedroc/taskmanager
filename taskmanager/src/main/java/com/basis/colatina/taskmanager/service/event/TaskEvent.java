package com.basis.colatina.taskmanager.service.event;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TaskEvent extends DefaultEvent {
    public TaskEvent(Integer id) {
        super(id);
    }
}
