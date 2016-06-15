package com.jim.controller;

import com.jim.model.Article;
import com.jim.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/article")
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = {"", "/", "/articles"}, method = RequestMethod.GET)
    public List<Article> index(){
        return articleService.articles();
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    @ResponseBody
    public long create(@RequestBody Article article){
        return articleService.create(article);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Article read(@PathVariable long id){
        return articleService.read(id);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.PUT)
    @ResponseBody
    public long update(@RequestBody Article article){
        return articleService.update(article);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public long delete(@PathVariable long id){
        return articleService.delete(id);
    }
}
