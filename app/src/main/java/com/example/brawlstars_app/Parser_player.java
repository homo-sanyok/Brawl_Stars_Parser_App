package com.example.brawlstars_app;

import android.util.Log;

import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Parser_player {
    private Document doc = null;
    String nickname = new String();
    String cups = new String();
    String id = new String();
    String vins = new String();
    int rank_25 = 0;
    int rank_30 = 0;

    Parser_player(String tag){
        id = tag;
        try {
            doc = Jsoup.connect("https://www.starlist.pro/stats/profile/" + id).get();
            Elements elements_tbody = doc.getElementsByTag("tbody");
            if (elements_tbody.size() != 0){
                Element element_table = elements_tbody.get(1);
                Elements elements_table = element_table.children();
                Element element_on_table = elements_table.get(3);
                Elements vins_ = element_on_table.children();
                vins = vins_.get(1).text();

                Elements count_elements = doc.getElementsByClass("text-left text-hp shadow-normal");
                String[] tokens = count_elements.get(0).text().split(" ");

                Elements rank_tables = doc.getElementsByClass("container-fluid post-type1");
                Element rank_table = rank_tables.get(1);
                Elements hero_info = rank_table.getElementsByClass("text-hp brl-btm-l pr-1");

                for (int i = 0; i < hero_info.size(); i++){
                    String[] tokens_hero_info = hero_info.get(i).html().split(" ");
                    int rank = Integer.parseInt(tokens_hero_info[5].split("\"")[0]);
                    if (rank >= 30){
                        rank_30++;
                    }
                    else if (rank >= 25){
                        rank_25++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
