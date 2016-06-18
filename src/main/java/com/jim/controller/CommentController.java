package com.jim.controller;

import com.jim.common.BlogBase;
import com.jim.model.Comment;
import com.jim.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jim.liu on 2016-06-17.
 * This class is ...
 */
@RestController
public class CommentController implements BlogBase {

    @Autowired
    private CommentService commentService;
    /**
     * Get comments by article id
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/article/{articleId}/comments", method = RequestMethod.GET)
    public List<Comment> index(@PathVariable long articleId) {
        return commentService.index(articleId);
    }


    /**
     * Create a new comment for a article
     *
     * @param articleId
     * @param comment
     * @return
     */
    @RequestMapping(value = "/article/{articleId}/comment", method = RequestMethod.POST)
    public int create(@PathVariable long articleId, Comment comment) {
        return commentService.create(articleId, comment);
    }

    /**
     * Read a comment by id
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public Comment read(@PathVariable long id) {
        return commentService.read(id);
    }

    /**
     * Update a comment
     *
     * @param comment
     * @return
     */
    @RequestMapping(value = "/comment", method = RequestMethod.PUT)
    public int update(@PathVariable Comment comment) {
        return commentService.update(comment);
    }

    /**
     * Delete a comment by id
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable long id) {
        return commentService.delete(id);
    }


    /**
     * Get sub Comments by comment's id
     * @param id
     * @return
     */
    @RequestMapping(value = "/comment/{id}/comments")
    public List<Comment> subComments(@PathVariable long id){
        return commentService.subComments(id);
    }
}
