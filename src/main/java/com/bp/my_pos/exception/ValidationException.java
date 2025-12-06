package com.bp.my_pos.exception;

import org.springframework.http.HttpStatus;

/**
 * ----------------------------------------------------------------------------
 *  Author      : Udara Wikum
 *  Date        : 2025-12-04 09:32 AM
 *  Developed with an Intelligent Approach
 * ----------------------------------------------------------------------------
 */

public class ValidationException extends PosServiceException {

    public ValidationException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
