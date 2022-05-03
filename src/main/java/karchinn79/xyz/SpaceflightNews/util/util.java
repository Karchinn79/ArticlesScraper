package karchinn79.xyz.SpaceflightNews.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class util {
    static List<String> blackList = new ArrayList<>();


    public static List<Pattern> blackListPatterns =
            blackList
                    .stream()
                    .map(word -> Pattern.compile("\\b" + Pattern.quote(word) + "\\b"))
                    .collect(Collectors.toList());
    public static void addWord(String word){
        if(word == null || word.equals("")){
            //exception here
        }
        else{
            blackList.add(word);
        }
    }

}
