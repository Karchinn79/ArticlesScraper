package karchinn79.xyz.SpaceflightNews;

import karchinn79.xyz.SpaceflightNews.entity.Article;
import karchinn79.xyz.SpaceflightNews.util.Util;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
public class Communication {
    @Autowired
    private RestTemplate restTemplate;


    private final String webURL = "https://api.spaceflightnewsapi.net/v3/articles";
    private final String LIMITPARAM = "?_limit=";
    private final String SKIPPARAM = "&_start=";

    public List<Article> getArticles (int limit, int skips){
        String URL;
        if(limit > 0 && skips > 0) URL = webURL + LIMITPARAM + limit + SKIPPARAM + skips;
        else URL = webURL;

        ResponseEntity<List<Article>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                });
        List<Article> allArticles = responseEntity.getBody();

         List<Pattern> blackListPatterns =
                Util.blackList
                        .stream()
                        .map(word -> Pattern.compile("\\b" + Pattern.quote(word) + "\\b"))
                        .collect(Collectors.toList());

        ArrayList<Integer> ids = new ArrayList<>();
        System.out.println("slurp");
        for(int i = 0; i < allArticles.size(); i++){

            for (Pattern pattern : blackListPatterns) {
                if (pattern.matcher(allArticles.get(i).getTitle()).find()) {
                    ids.add(i);
                    System.out.println("slurp2");
                }
            }
        }
        System.out.println(ids + " splark");
        int lastElem = ids.size()-1;
        for(int i = ids.size()-1; i>=0; i-- ){
           allArticles.remove(i);


        }
        return allArticles;
    }

    public Article getArticle(int id){
        final String URL = "https://api.spaceflightnewsapi.net/v3/articles/" + id;
        ResponseEntity<Article> responseEntity;
        try {
            responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<Article>() {
            });
        }
        catch (HttpClientErrorException ex){
            return null;
        }
        return responseEntity.getBody();
    }
    public void saveArticle(Article article){

    }
    public void removeArticle(int id){

    }
    public int getFirstArticleID(int skips){
        String URL;
        final int LIMIT_TO_GET_FIRST = 1;
        if(skips > 0) URL = webURL + LIMITPARAM + LIMIT_TO_GET_FIRST + SKIPPARAM + skips;
        else URL = webURL + LIMITPARAM + LIMIT_TO_GET_FIRST;
        ResponseEntity<List<Article>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Article>>() {
                });
        return responseEntity.getBody().get(0).getId();
    }
}

