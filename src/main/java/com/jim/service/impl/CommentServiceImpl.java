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

package com.jim.service.impl;

import com.jim.mapper.CommentMapper;
import com.jim.model.Comment;
import com.jim.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liqing on 2016/6/17.
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> index(long articleId) {
        return commentMapper.comments(articleId);
    }

    @Override
    public int create(long articleId, Comment comment) {
        return commentMapper.insert(comment);
    }

    @Override
    public Comment read(long id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Comment comment) {
        return commentMapper.updateByPrimaryKey(comment);
    }

    @Override
    public int delete(long id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Comment> subComments(long id) {
        return commentMapper.subComments(id);
    }
}
