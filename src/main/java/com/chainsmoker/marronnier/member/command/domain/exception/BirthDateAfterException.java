package com.chainsmoker.marronnier.member.command.domain.exception;

public class BirthDateAfterException extends IllegalArgumentException {

    public BirthDateAfterException(String msg) {
        super(msg);
    }
}
