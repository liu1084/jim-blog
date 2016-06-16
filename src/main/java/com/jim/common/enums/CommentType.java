package com.jim.common.enums;

import com.jim.common.Type;

/**
 * Created by liqing on 2016/6/17.
 */
public class CommentType implements Type {
    private String typeName;
    private int index;

    public String getTypeName() {
        return typeName;
    }

    public int getIndex() {
        return index;
    }

    public CommentType(String typeName, int index) {
        this.typeName = typeName;
        this.index = index;
    }

    @Override
    public String info() {
        return Integer.toString(this.index);
    }
}
