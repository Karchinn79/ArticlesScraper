package karchinn79.xyz.SpaceflightNews.controller;

import karchinn79.xyz.SpaceflightNews.logic.Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController("/articles/api")
public class RestController {
    @Autowired
    Logic logic;

    @GetMapping("/api/getBlackList")
    public List<String> getBlackList(){
        return logic.getBlackList();
    }

}
