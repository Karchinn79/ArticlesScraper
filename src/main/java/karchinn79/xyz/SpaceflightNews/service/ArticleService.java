package karchinn79.xyz.SpaceflightNews.service;

import karchinn79.xyz.SpaceflightNews.DAO.ArticlesDAO;
import karchinn79.xyz.SpaceflightNews.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticlesDAO articlesDAO;

    @Transactional
    public List<Article> getAllArticles(){
        return articlesDAO.findAll();
    }
    @Transactional
    public void saveArticle(Article article){
        articlesDAO.save(article);
    }
    @Transactional
    public Article getAticleById(int id){
        return articlesDAO.getById(id);
    }
    @Transactional
    public void removeArticleById(int id){
        articlesDAO.deleteById(id);
    }
    public boolean isExists(int id){
        return articlesDAO.existsById(id);
    }
}
