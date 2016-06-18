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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jim.common.BlogBase;
import com.jim.model.Article;
import com.jim.model.Comment;
import com.jim.service.ArticleService;
import com.jim.service.CommentService;

@RequestMapping(value = "/article")
@RestController
public class ArticleController implements BlogBase {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    /**
     * Get all articles
     * @return
     */
    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public List<Article> index(){
        return articleService.articles();
    }

    /**
     * Create a new article
     * @param article
     * @return
     */
    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public long create(@RequestBody Article article){
        return articleService.create(article);
    }

    /**
     * Get a article by id
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Article read(@PathVariable long id){
        return articleService.read(id);
    }

    /**
     * Update a article
     * @param article
     * @return
     */
    @RequestMapping(value = {"", "/"}, method = RequestMethod.PUT)
    public long update(@RequestBody Article article){
        return articleService.update(article);
    }

    /**
     * Delete a article
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public long delete(@PathVariable long id){
        return articleService.delete(id);
    }

    /**
     * Get comments by article id
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}/comments", method = RequestMethod.GET)
    public List<Comment> index(@PathVariable long id) {
        return commentService.index(id);
    }


    /**
     * Create a new comment for a article
     *
     * @param id
     * @param comment
     * @return
     */
    @RequestMapping(value = "/{id}/comment", method = RequestMethod.POST)
    public int create(@PathVariable long id, Comment comment) {
        return commentService.create(id, comment);
    }
}
