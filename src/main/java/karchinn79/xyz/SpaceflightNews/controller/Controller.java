package karchinn79.xyz.SpaceflightNews.controller;

import karchinn79.xyz.SpaceflightNews.logic.Logic;
import karchinn79.xyz.SpaceflightNews.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/articles")
public class Controller {

    @Autowired
    ArticleService articleService;
    @Autowired
    Logic logic;

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

    @GetMapping("/clearDB")
    public String clearDB(){
        articleService.clearDB();
        return "redirect:./";
    }

    @GetMapping("/loadArticles")
    public String loadArticles(){
        logic.loadArticles();
        return "redirect:./";
    }

    @GetMapping("/addToBlackList/{word}")
    public String addToBlackList(@PathVariable("word") String word){
        logic.addToBlackList(word);
        return "redirect:../";
    }

    @GetMapping("/loadArticlesMulti/{limit}")
    public String loadArticlesMulti(@PathVariable("limit") String limits){
        int limit = Integer.parseInt(limits);
        logic.loadMultipleArticles(1,limit);
        return "redirect:./";
    }
    @GetMapping("/loadArticle/{id}")
    public String loadArticle(@PathVariable("id") int id){
        logic.loadArticlebyId(id);
        return "redirect:./";
    }
}
