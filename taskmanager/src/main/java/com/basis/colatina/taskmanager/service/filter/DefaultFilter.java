package com.basis.colatina.taskmanager.service.filter;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DefaultFilter implements Serializable {

    protected String query;

    protected Boolean status;

}
