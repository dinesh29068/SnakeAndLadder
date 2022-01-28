package com.example.snakeladder;

import com.example.snakeladder.entities.Board;
import com.example.snakeladder.entities.Player;
import com.example.snakeladder.DiceService;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    Board board;
    Queue<Player> players;
    Queue<Player> winners;
    int diceCount;
    int dimension;
    int size;
    public Game(int dimension, int diceCount){
        this.size= dimension*dimension;
        this.dimension= dimension;
        this.diceCount= diceCount;
        board= new Board(dimension);
        players= new LinkedList<Player>();
        winners= new LinkedList<Player>();
    }
    public void launch(){
        this.board.print();
        while(players.size() > 1){
            Player currPlayer= players.poll();
            System.out.println();
            System.out.println(currPlayer.getPlayerName()+"'s turn");
            System.out.println("Press r to roll the dice");

            Scanner sc= new Scanner(System.in);
            char c= sc.next().charAt(0);
            makeMove(currPlayer);
            if(currPlayer.getPlayerNo() == size){
                System.out.println(currPlayer.getPlayerName()+ " won!!");
                winners.add(currPlayer);
            }
            else{
                players.add(currPlayer);
            }
            printPosition();
        }
    }
    private void printPosition(){
        for(Player player: players){
            System.out.println(player.getPlayerName()+ ":" +player.getPlayerNo());
        }
    }
    private void makeMove(Player player){
        int currPosition= player.getPlayerNo();
        int move= DiceService.roll(this.diceCount);
        System.out.println("You Got"+  move);
        int finalPos= currPosition+move;
        if(finalPos<=size){
            if(board.hasSnakeOrLadder(finalPos)){
                System.out.println(board.getEntity(finalPos).getEncounterMessage());
                finalPos= board.getEntity(finalPos).getEnd();
            }
            System.out.println("Taking you to"+ finalPos);
        }else{
            System.out.println("Taking you to next turn");
            finalPos= currPosition;
        }
        player.setPlayerNo(finalPos);
    }
    public Queue<Player> getPlayers(){
        return players;
    }
    public void addPlayer(Player player){
        this.players.add(player);
    }
    public Queue<Player> getWinners(){
        return winners;
    }
    public void setPlayers(Queue<Player> players){
        this.players= players;
    }
    public void  setWinners(Queue<Player> winners){
        this.winners= winners;
    }
    public int getSize(){
        return size;
    }
    public void setSize(int size){
        this.size=size;
    }
    public int getDiceCount(){
        return diceCount;
    }
    public void setDiceCount(int size){
        this.size=size;
    }

}
