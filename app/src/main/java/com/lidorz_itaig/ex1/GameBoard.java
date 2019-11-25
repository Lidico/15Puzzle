package com.lidorz_itaig.ex1;

import java.util.Random;

public class GameBoard {

    //Varibles decleration.
    final static int NUM_OF_ARRAY = 16;
    final static int NUM_OF_LINES = 4;
    private String[][] finishGameArray= {{"a","b","c","d"},{"e","f","g","h"},{"i","j","k","l"},{"m","n","o","p"}};
    private String[][] toBoard = new String[NUM_OF_LINES][NUM_OF_LINES];
    private int[] randNums = new int[NUM_OF_ARRAY];
    private boolean isNumberSolvable = false;
    //odd is false - even is true
    private boolean isLineEven = false;
    private int[] pPosition = new int[2];
    private int inverts;

    //Constractur.
    public GameBoard() {
        setToBoard();
    }

    // Getters
    public String[][] getToBoard() {
        return toBoard;
    }

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

    public int[] getPPosition() {
        return pPosition;
    }

    // Setters
    public void setRandNums() {
        this.randNums = randomizeTheNums();
    }

    public void setToBoard() {
        setRandNums();
        this.toBoard = toLetters(this.randNums);

    }

    public void setPPosition() {
        this.pPosition = setPP(this.toBoard);
    }

    public void swapPosition(int[] pPos, int[] pressedPos) {
        String temp = this.toBoard[pPos[0]][pPos[1]];
        this.toBoard[pPos[0]][pPos[1]] = toBoard[pressedPos[0]][pressedPos[1]];
        this.toBoard[pressedPos[0]][pressedPos[1]] = temp;
        this.pPosition[0] = pressedPos[0];
        this.pPosition[1] = pressedPos[1];
    }

    public boolean isGameOver() {
        int count = 0;
        for(int i=0; i<4; i++) {
            for(int j=0;j<4;j++) {
                if(this.finishGameArray[i][j].equals(this.toBoard[i][j])) {
                    count++;
                }
            }
        }
        if (count==16) {
            return true;
        }
        else {
            return false;
        }
    }

    private String[][] toLetters(int[] arr) {
        String[] newArr = new String[NUM_OF_ARRAY];
        String[][] newDoubleArray = new String[NUM_OF_LINES][NUM_OF_LINES];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = String.valueOf((char) (arr[i] + 96));
        }
        int row = 0;
        int col = 0;
        for (int i = 0; i < newArr.length; i++) {
            newDoubleArray[row][col] = newArr[i];
            col++;
            if ((i + 1) % 4 == 0) {
                row++;
                col = 0;
            }
        }
        return newDoubleArray;
    }

    //random numbers app that checks if it solvable
    private int[] randomizeTheNums() {
        int[] initArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int[] newArr = shuffleArray(initArr);

        this.isNumberSolvable = checkSolvability(newArr);
        while (geIsNumberSolvable() != true) {
            newArr = shuffleArray(initArr);
            this.isNumberSolvable = checkSolvability(newArr);
        }
        return newArr;
    }

    //Currect P position.
    private int[] setPP(String[][] arr) {
        int[] positionArr = new int[2];
        for (int i = 0; i < NUM_OF_LINES; i++) {
            for (int j = 0; j < NUM_OF_LINES; j++) {
                if (arr[i][j].equals("p")) {
                    positionArr[0] = i;
                    positionArr[1] = j;
                    break;
                }
            }
        }
        return positionArr;
    }

    //function that check if the game can be solvable.
    // Source - https://www.geeksforgeeks.org/check-instance-15-puzzle-solvable/
    private boolean checkSolvability(int[] arr) {

        this.inverts = howManyInverts(arr);
        this.isLineEven = whereIsBlank(arr);
        if (this.inverts % 2 == 0 && !isLineEven) {
            return true;
        } else if (this.inverts % 2 == 1 && isLineEven) {
            return true;
        } else {
            return false;
        }
    }

    //count how many inverts in the array.
    private int howManyInverts(int[] arr) {
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
    private boolean whereIsBlank(int[] arr) {
        int line = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 16) {
                break;
            }
            if ((i + 1) % 4 == 0) {
                line++;
            }
        }
        //  System.out.println(line);
        if (line % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }

    //shuffled the array.
    private int[] shuffleArray(int[] arr) {
        Random rnd = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
        return arr;
    }
}
