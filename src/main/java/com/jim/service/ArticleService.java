package com.jim.service;

import com.jim.model.Article;

import java.util.List;

/**
 * Created by liqing on 2016/6/4.
 */
public interface ArticleService extends BaseService {
    long create(Article article);

    Article read(long id);

    int update(Article article);

    int delete(long id);

    List<Article> articles();
}
