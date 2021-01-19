package com.example.brawlstars_app;

import android.content.Intent;
import android.os.Debug;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.Console;
import java.io.IOException;
import java.io.Serializable;
import java.util.Vector;

public class Parser_clan {
    private Document doc = null;
    private Vector<String> nicknames = new Vector<String>();
    private Vector<String> cups = new Vector<String>();
    private Vector<String> player_id = new Vector<String>();

    Parser_clan(String teg){
        try {
            this.doc = Jsoup.connect("https://www.starlist.pro/stats/club/" + teg).get();
            Elements elements_tbody = this.doc.getElementsByTag("tbody");

            if (elements_tbody.size() == 3){

                Element element_tbody = elements_tbody.get(2);
                Elements elements_players = element_tbody.children();

                int n = elements_players.size();

                for (int i = 0; i < n; i++){
                    Element player = elements_players.get(i);
                    Elements player_info = player.children();

                    if (player.id().length() != 0){
                        this.player_id.add(player.id());
                        this.nicknames.add(player_info.get(1).text());
                        this.cups.add(player_info.get(3).text());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Vector<String> getNicknames(){
        return this.nicknames;
    }

    public Vector<String> getCups(){
        return this.cups;
    }

    public Vector<String> getPlayer_id(){
        return this.player_id;
    }
}


































