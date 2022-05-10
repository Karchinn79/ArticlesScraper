package karchinn79.xyz.SpaceflightNews.util;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class Util {

    public static List<String> blackList = new ArrayList<>();

    public static void addWord(String word){
        if(word == null || word.equals("")){
            //exception here
        }
        else{
            blackList.add(word);
        }
    }

    public static List<String> getBlackList() {
        return blackList;
    }
}
