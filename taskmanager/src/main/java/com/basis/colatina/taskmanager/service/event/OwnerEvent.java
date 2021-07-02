package com.basis.colatina.taskmanager.service.event;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OwnerEvent extends DefaultEvent {
    public OwnerEvent(Integer id) {
        super(id);
    }
}
