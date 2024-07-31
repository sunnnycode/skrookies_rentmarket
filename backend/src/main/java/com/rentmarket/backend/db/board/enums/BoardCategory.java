package com.rentmarket.backend.db.board.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BoardCategory {

    CLOTHES( "의류"),

    KITHEN("주방용품"),
    ;


    private String description;
}
