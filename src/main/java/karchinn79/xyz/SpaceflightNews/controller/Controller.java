package karchinn79.xyz.SpaceflightNews.controller;

import karchinn79.xyz.SpaceflightNews.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/articles/")
public class Controller {
    @Autowired
    ArticleService articleService;

    @RequestMapping("/")
    public String getAllArticles(Model model){
        model.addAttribute("articles", articleService.getAllArticles());
        return "dbcontent";
    }
    @RequestMapping("/{id}")
    public String getArticleById(@PathVariable("id") int id, Model model){
        model.addAttribute("articleid", articleService.getAticleById(id));
        return "articleById";
    }
}
