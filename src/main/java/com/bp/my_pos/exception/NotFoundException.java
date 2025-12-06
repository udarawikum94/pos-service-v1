package com.bp.my_pos.exception;

import org.springframework.http.HttpStatus;

/**
 * ----------------------------------------------------------------------------
 *  Author      : Udara Wikum
 *  Date        : 2025-12-04 09:28 AM
 *  Developed with an Intelligent Approach
 * ----------------------------------------------------------------------------
 */

public class NotFoundException extends PosServiceException {

    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
