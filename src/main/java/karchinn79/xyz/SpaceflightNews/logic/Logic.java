package karchinn79.xyz.SpaceflightNews.logic;

import karchinn79.xyz.SpaceflightNews.Communication;

import karchinn79.xyz.SpaceflightNews.entity.Article;
import karchinn79.xyz.SpaceflightNews.service.ArticleService;
import karchinn79.xyz.SpaceflightNews.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class Logic {
    @Autowired
    Communication communication;
    @Autowired
    ArticleService articleService;
    @Autowired
    ApplicationContext applicationContext;
    static List<Article> inMemoryArticles = new ArrayList<>();

    public void loadArticles(){

        List<Article> ars = communication.getArticles(0,0);
        for(Article a : ars){
            articleService.saveArticle(a);//14907
            //System.out.println(a);
        }
    }
    @Async
    public void loadMultipleArticles(int start, int limit){
        int tasksCount = limit;
        int threadsCount = 4;
        //if (start == 0 && skip == 0){}

        int firstID = communication.getFirstArticleID(start);
        System.out.println(firstID);
        System.out.println("!!!SUKA line 38 executed");
        int actualtasksCount = (int) (tasksCount*1.6);
        TaskExecutor taskExecutor = applicationContext.getBean("taskExecutor", TaskExecutor.class);
        for(int i = firstID; i < firstID+actualtasksCount; i++){

            taskExecutor.execute(new LoaderThread(i));
            }

        System.out.println(inMemoryArticles);
    }

    public void loadArticlebyId(int id){
        inMemoryArticles.add(communication.getArticle(id));
        System.out.println(inMemoryArticles);
    }

    public void addToBlackList(String word){
        Util.addWord(word);
        System.out.println(word);
    }
    public List<String> getBlackList(){
        return Util.getBlackList();
    }
}


class LoaderThread implements Runnable{
    Communication communication = new Communication();
    private int id;
    public LoaderThread(int id){
        this.id = id;
    }
    @Override
    public void run() {
        synchronized (Logic.inMemoryArticles) {
            Logic.inMemoryArticles.add(communication.getArticle(id));
        }
    }
}
