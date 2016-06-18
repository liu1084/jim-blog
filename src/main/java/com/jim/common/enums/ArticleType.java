/*
 * The MIT License (MIT)
 * Copyright (c) 2016 Jim Liu
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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
