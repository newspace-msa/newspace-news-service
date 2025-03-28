package com.lgcns.newspacenewsservice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum NewsResponseStatus {

    NOT_FOUND_CATEGORY(false, 4106, "해당 카테고리 id에 맞는 카테고리를 찾을 수 없습니다."),
    NOT_FOUND_KEYWORD(false, 4107, "해당 키워드 id에 맞는 키워드를 찾을 수 없습니다.");


    private final boolean isSuccess;
    private final int code;
    private final String message;
    private HttpStatus httpStatus;

    NewsResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }

    NewsResponseStatus(boolean isSuccess, int code, String message, HttpStatus httpStatus) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
