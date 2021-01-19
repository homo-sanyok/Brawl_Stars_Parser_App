package com.example.brawlstars_app;

import android.util.Log;

import java.util.Vector;

public class Clan{
    Vector<String> nicknames; //имена игроков клана
    Vector<String> cups; //кубки игроков клана
    Vector<String> vins = new Vector<String>(); //победы игроков клана
    Vector<Integer> rank_30 = new Vector<Integer>();
    Vector<Integer> rank_25 = new Vector<Integer>();
    public int length = 0; //кол-во участников

    public Clan(Vector<String> nicknames, Vector<String> cups){
        this.nicknames = nicknames;
        this.cups = cups;
        this.length = nicknames.size();
    }

    public void addVins(String str){
        vins.add(str);
    }

    public void addRanks(Integer rank_30, Integer rank_25){
        this.rank_30.add(rank_30);
        this.rank_25.add(rank_25);
    }

    public String[] getVins(){
        String[] res = new String[vins.size()];
        for (int i = 0; i < res.length; i++){
            res[i] = vins.get(i).replaceAll(",", "");;
        }
        return res;
    }

    public String[] getNicknames(){
        String[] res = new String[nicknames.size()];
        for (int i = 0; i < res.length; i++){
            res[i] = nicknames.get(i);
        }
        return res;
    }

    public String[] getCups(){
        String[] res = new String[cups.size()];
        for (int i = 0; i < res.length; i++){
            res[i] = cups.get(i).replaceAll(",", "");
        }
        return res;
    }

    public int getLength(){
        return length;
    }

    public String[] getSplitNicknamesCups(){
        String[] res = new String[nicknames.size()];
        for (int i = 0; i < res.length; i++){
            res[i] = nicknames.get(i) + " | " + cups.get(i);
        }
        return res;
    }

    public String[] getRank_30(){
        String[] res = new String[rank_30.size()];
        for (int i = 0; i < res.length; i++){
            res[i] = Integer.toString(rank_30.get(i));
        }
        return res;
    }

    public String[] getRank_25(){
        String[] res = new String[rank_25.size()];
        for (int i = 0; i < res.length; i++){
            res[i] = Integer.toString(rank_25.get(i));
        }
        return res;
    }
}































