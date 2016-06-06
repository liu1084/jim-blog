package com.jim.service.impl;

import com.jim.mapper.ArticleMapper;
import com.jim.model.Article;
import com.jim.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liqing on 2016/6/4.
 */

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public long create(Article article) {
        return articleMapper.insert(article);
    }

    @Override
    public Article read(long id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Article article) {
        return articleMapper.updateByPrimaryKey(article);
    }

    @Override
    public int delete(long id) {
        return articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Article> all() {
        return articleMapper.articles();
    }
}
