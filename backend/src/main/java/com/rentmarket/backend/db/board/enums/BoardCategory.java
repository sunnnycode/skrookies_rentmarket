package com.rentmarket.backend.db.board.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BoardCategory {

    CLOTHES( "의류"),

    KITHEN("주방용품"),
    ;


    private String description;
}
