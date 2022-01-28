package com.example.snakeladder.entities;

import java.util.HashMap;
import java.util.Map;

public class Board {
    Map<Integer, BoardEntity> cells;
    int cellCount;

    public Board(int dimension){
        this.cellCount = dimension*dimension;
        cells = new HashMap<Integer, BoardEntity>();
        for(int i=0; i< dimension; i++){
            int min=2;
            int max= cellCount-1;
            int start= (int)Math.floor(Math.random()*(max-min+1)+min);
            max= start-1;
            int end= (int)Math.floor(Math.random()*(max-min+1)+min);
            if(!hasSnakeOrLadder(start)){
                setEntity(start, new Snake(start, end));
            }
            max= cellCount-1;
            end= (int)Math.floor(Math.random()*(max-min+1)+min);
            max= end-1;
            start= (int)Math.floor(Math.random()*(max-min+1)+min);
            if(!hasSnakeOrLadder(start)){
                setEntity(start, new Ladder(start, end));
            }
        }


    }
    public void print(){
        for(int i=cellCount-1; i>0; i++){
            System.out.print(i+" ");
            if(hasSnakeOrLadder(i)){
                System.out.print(cells.get(i).getString());
            }else{
                System.out.print(" ");
            }
            if(i%10 ==0)
                System.out.println();
        }
        System.out.println();
    }
    public void setEntity(int index, BoardEntity e){
        cells.put(index, e);
    }
    public BoardEntity getEntity(int index)
    {
        if(hasSnakeOrLadder(index)){
            return this.cells.get(index);
        }
        return null;
    }
    public boolean hasSnakeOrLadder(int index){
        return cells.containsKey(index);
    }
}
