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
