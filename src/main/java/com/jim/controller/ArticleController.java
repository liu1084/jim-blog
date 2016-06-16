package com.jim.controller;

import com.jim.common.BlogBase;
import com.jim.model.Article;
import com.jim.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/article")
@RestController
public class ArticleController implements BlogBase {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = {"", "/", "/articles"}, method = RequestMethod.GET)
    public List<Article> index(){
        return articleService.articles();
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public long create(@RequestBody Article article){
        return articleService.create(article);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Article read(@PathVariable long id){
        return articleService.read(id);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.PUT)
    public long update(@RequestBody Article article){
        return articleService.update(article);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public long delete(@PathVariable long id){
        return articleService.delete(id);
    }
}
