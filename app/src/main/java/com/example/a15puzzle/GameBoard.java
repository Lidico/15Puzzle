package com.example.a15puzzle;

import java.util.Random;

public class GameBoard {

    //Varibles decleration.
    private int[] randNums = new int[16];
    private boolean isNumberSolvable = false;
    //odd is false - even is true
    private boolean isLineEven = false;
    private int inverts;

    //Constractur.
    public GameBoard(){
        setRandNums();
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
    public void setRandNums() {
        this.randNums = randomizeTheNums();
    }


    //random numbers app that checks if it solvable
    private int[] randomizeTheNums(){
        int[] initArr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        int[] newArr= shuffleArray(initArr);

        this.isNumberSolvable = checkSolvability(newArr);
        while(geIsNumberSolvable()!=true) {
            newArr = shuffleArray(initArr);
            this.isNumberSolvable = checkSolvability(newArr);
        }
        return newArr;
    }

    //function that check if the game can be solvable.
    private boolean checkSolvability(int[] arr){

        this.inverts = howManyInverts(arr);
        this.isLineEven = whereIsBlank(arr);
        if(this.inverts%2==0 && !isLineEven){
            return true;
        }
        else if(this.inverts%2==1 && isLineEven){
            return true;
        }
        else{
            return false;
        }
    }

    //count how many inverts in the array.
    private int howManyInverts(int[] arr){
        int invCount = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    invCount++;
                }
            }
        }
        return invCount;
    }

    //check in which line is the blank(16).
    private boolean whereIsBlank(int[] arr){
        int line = 1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==16){
                break;
            }
            if((i+1)%4==0){
                line++;
            }
        }
        //  System.out.println(line);
        if(line%2==0){
            return true;
        }
        else{
            return false;
        }
    }

    //shuffled the array.
    private int[] shuffleArray(int[] arr){
        Random rnd = new Random();
        for (int i = arr.length - 1; i > 0; i--){
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
        return arr;
    }