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

@RestController
public class CommentController implements BlogBase {

    @Autowired
    private CommentService commentService;

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
