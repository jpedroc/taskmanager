package com.basis.colatina.taskmanager.service.event;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CommentEvent extends DefaultEvent {
    public CommentEvent(Integer id) {
        super(id);
    }
}
