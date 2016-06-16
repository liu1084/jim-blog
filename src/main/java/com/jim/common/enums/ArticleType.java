package com.jim.common.enums;

import com.jim.common.Type;

/**
 * Created by liqing on 2016/6/16.
 */
public enum ArticleType implements Type {
    DRAFT("draft", 0), PUBLIC("public", 1), PRIVATE("private", 2);
    private String typeName;
    private int index;

    public String getTypeName() {
        return typeName;
    }

    public int getIndex() {
        return index;
    }


    ArticleType(String typeName, int index) {
        this.typeName = typeName;
        this.index = index;
    }

    @Override
    public String info() {
        return Integer.toString(this.index);
    }
}
