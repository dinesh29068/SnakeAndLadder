package com.example.snakeladder.entities;

public class Ladder extends BoardEntity {
    public Ladder(int start, int end){
        super(start, end);
    }

    @Override
    public String getEncounterMessage(){
        return "You have a ladder to climb";
    }
    @Override
    public String getString(){
        return "L("+this.getEnd()+")";
    }
}
