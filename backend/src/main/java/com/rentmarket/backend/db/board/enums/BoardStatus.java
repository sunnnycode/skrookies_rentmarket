package com.rentmarket.backend.db.board.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BoardStatus {

    SALE("판매중"),

    RESERVED("예약중"),

    SOLD("판매완료"),
    ;


    private String description;

}
