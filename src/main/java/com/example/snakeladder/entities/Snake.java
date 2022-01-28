package com.example.snakeladder.entities;

public class Snake extends BoardEntity {
    public Snake(int start, int end){
        super(start, end);
    }

    @Override
    public String getEncounterMessage(){
        return "You have a Snake Oops!!";
    }
    @Override
    public String getString(){
        return "S("+this.getEnd()+")";
    }
}
