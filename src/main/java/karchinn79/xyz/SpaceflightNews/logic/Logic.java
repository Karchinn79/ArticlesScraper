package karchinn79.xyz.SpaceflightNews.logic;

import karchinn79.xyz.SpaceflightNews.Communication;

import karchinn79.xyz.SpaceflightNews.entity.Article;
import karchinn79.xyz.SpaceflightNews.service.ArticleService;
import karchinn79.xyz.SpaceflightNews.util.Util;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class Logic {
    @Autowired
    Communication communication;
    @Autowired
    ArticleService articleService;


    public void loadArticles(){

        List<Article> ars = communication.getArticles(0,0);
        for(Article a : ars){
            articleService.saveArticle(a);//14907
            //System.out.println(a);
        }
    }
    public void addToBlackList(String word){
        Util.addWord(word);
        System.out.println(word);
    }
    public List<String> getBlackList(){
        return Util.getBlackList();
    }
}
