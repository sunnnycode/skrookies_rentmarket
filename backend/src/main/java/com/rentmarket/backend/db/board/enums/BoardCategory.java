package com.rentmarket.backend.db.board.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BoardCategory {

    CLOTHES( "의류"),

    KITHEN("주방용품"),

    CAMPING("캠핑"),

    BOOK("도서")
    ;


    private String description;
}
