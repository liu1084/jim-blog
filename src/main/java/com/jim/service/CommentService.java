package com.jim.service;

import com.jim.model.Comment;

import java.util.List;

/**
 * Created by liqing on 2016/6/17.
 */
public interface CommentService {
    List<Comment> index(long articleId);
    int create(long articleId,Comment comment);
    Comment read(long id);
    int update(Comment comment);
    int delete(long id);
    List<Comment> subComments(long id);
}
