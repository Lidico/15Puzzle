package com.example.a15puzzle;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GameBoard {
    //Varibles decleration
    private int[] randNums = new int[16];
    private boolean isNumberSolvable = false;
    //odd is false - even is true
    private boolean isLineEven = false;
    private int inverts;

    //Constractur
    public GameBoard(){
        if(!isNumberSolvable){

        }
    }

    // Getters
    public int[] getRandNums() {
        return randNums;
    }

    public boolean geIsNumberSolvable() {
        return isNumberSolvable;
    }

    public boolean geIsLineEven() {
        return isLineEven;
    }

    public int getInverts() {
        return inverts;
    }

    // Setters
    public void setRandNums(int[] randNums) {
        this.randNums = randomizeTheNums();
    }


    public void setInverts(int inverts) {
        this.inverts = ;
    }

    //random numbers app that checks if it solvable
    private int[] randomizeTheNums(){
        int[] initArr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        int[] newArr;
        while()
            shuffleArray(initArr);
    }

    private int[] shuffleArray(int[] ar){
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--){
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }
}
