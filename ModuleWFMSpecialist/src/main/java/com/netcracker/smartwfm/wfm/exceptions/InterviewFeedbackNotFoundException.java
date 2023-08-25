package com.netcracker.smartwfm.wfm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class InterviewFeedbackNotFoundException extends RuntimeException {
    public InterviewFeedbackNotFoundException(String message) {
        super(message);
    }
}
