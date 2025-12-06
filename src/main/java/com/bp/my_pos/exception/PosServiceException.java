package com.bp.my_pos.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * ----------------------------------------------------------------------------
 *  Author      : Udara Wikum
 *  Date        : 2025-12-04 09:26 AM
 *  Developed with an Intelligent Approach
 * ----------------------------------------------------------------------------
 */

@Getter
public class PosServiceException extends RuntimeException {

    private final HttpStatus status;

    public PosServiceException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

}
