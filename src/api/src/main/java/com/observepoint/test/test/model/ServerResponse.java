package com.observepoint.test.test.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServerResponse {
    private boolean status;
    private String message;

    public ServerResponse(boolean status, String message){
        this.status = status;
        this.message = message;
    }
}
