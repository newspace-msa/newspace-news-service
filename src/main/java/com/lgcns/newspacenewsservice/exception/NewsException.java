package com.lgcns.newspacenewsservice.exception;

import lombok.Getter;

@Getter
public class NewsException extends RuntimeException {

    private NewsResponseStatus status;

    public NewsException(NewsResponseStatus status) {
        super(status.getMessage());
        this.status = status;
    }
}
