package karchinn79.xyz.SpaceflightNews.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Util {

    public static List<String> blackList = new ArrayList<>();
    {blackList.add("Intelsat");}
    public  void addWord(String word){
        if(word == null || word.equals("")){
            //exception here
        }
        else{
            blackList.add(word);
        }
    }

}
