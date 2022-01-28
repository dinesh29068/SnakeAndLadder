package com.example.snakeladder.entities;

public class Player {
    int playerNo;
    String playerName;

    public Player(String name){
        this.playerName= name;
    }

    public String getPlayerName(){
        return playerName;
    }
    public void setPlayerName(String playerName){
        this.playerName= playerName;
    }
    public int getPlayerNo(){
        return playerNo;
    }
    public void setPlayerNo(int playerNo){
        this.playerNo= playerNo;
    }
}
