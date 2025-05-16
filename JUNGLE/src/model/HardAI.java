package model;

import java.util.ArrayList;
import java.util.List;

public class HardAI {
    public Boolean isEnemy(int x,int y, char[][]charBoard){
        Boolean is = false;
        if(charBoard[x][y]=='r'||charBoard[x][y]=='i'||charBoard[x][y]=='l'||charBoard[x][y]=='w'||charBoard[x][y]=='c'||charBoard[x][y]=='t'
                ||charBoard[x][y]=='e'||charBoard[x][y]=='d'){
            is = true;
        }
    return is;}
    public int getRank(int x,int y, char[][]charBoard){
        int rank = 0;
        if(charBoard[x][y]=='r'){rank = 1;}
        if(charBoard[x][y]=='R'){rank = 1;}
        if(charBoard[x][y]=='C'){rank = 2;}
        if(charBoard[x][y]=='c'){rank = 2;}
        if(charBoard[x][y]=='D'){rank = 3;}
        if(charBoard[x][y]=='d'){rank = 3;}
        if(charBoard[x][y]=='W'){rank = 4;}
        if(charBoard[x][y]=='w'){rank = 4;}
        if(charBoard[x][y]=='L'){rank = 5;}
        if(charBoard[x][y]=='l'){rank = 5;}
        if(charBoard[x][y]=='T'){rank = 6;}
        if(charBoard[x][y]=='t'){rank = 6;}
        if(charBoard[x][y]=='I'){rank = 7;}
        if(charBoard[x][y]=='i'){rank = 7;}
        if(charBoard[x][y]=='E'){rank = 8;}
        if(charBoard[x][y]=='e'){rank = 8;}
    return rank;}
    public int getImportance(int x,int y, char[][]charBoard){
        int rank = 0;
        if(charBoard[x][y]=='r'){rank = 6;}
        if(charBoard[x][y]=='R'){rank = 6;}
        if(charBoard[x][y]=='C'){rank = 2;}
        if(charBoard[x][y]=='c'){rank = 2;}
        if(charBoard[x][y]=='D'){rank = 3;}
        if(charBoard[x][y]=='d'){rank = 3;}
        if(charBoard[x][y]=='W'){rank = 4;}
        if(charBoard[x][y]=='w'){rank = 4;}
        if(charBoard[x][y]=='L'){rank = 5;}
        if(charBoard[x][y]=='l'){rank = 5;}
        if(charBoard[x][y]=='T'){rank = 7;}
        if(charBoard[x][y]=='t'){rank = 7;}
        if(charBoard[x][y]=='I'){rank = 8;}
        if(charBoard[x][y]=='i'){rank = 8;}
        if(charBoard[x][y]=='E'){rank = 5;}
        if(charBoard[x][y]=='e'){rank = 5;}
        return rank;
    }

    public List<ArrayList<Integer>> getValue(char[][]charBoard, ArrayList<ArrayList<Integer>>canMoveX, ArrayList<ArrayList<Integer>>canMoveY,
                                  ArrayList<Integer>canChooseX,ArrayList<Integer>canChooseY){

        List<ArrayList<Integer>> StepsValue = new ArrayList<>();
        for (int i =0; i< canMoveY.size(); i++) {
                ArrayList<Integer> value = new ArrayList<>();
                for(int q=0; q<canMoveY.get(i).size(); q++){
                //越接近敌方基地，价值越高
                int step = 0;
                int t = 11 - (Math.abs(canMoveX.get(i).get(q) - 3) + Math.abs(canMoveY.get(i).get(q) - 8));
                if(t > step){step = t;}
                if(t == 11){step = 10000;}
                //若所选位置是敌人
                    List<Integer> Enemy = new ArrayList<>();
                    List<Integer> Eat = new ArrayList<>();
                    if ( isEnemy(canMoveY.get(i).get(q) , canMoveX.get(i).get(q), charBoard)) {
                        //System.out.println(model.charBoard.getCharBoard()[canMoveY.get(i).get(q)][canMoveX.get(i).get(q)]+" slkv");
                        //System.out.println(canMoveY.get(i)+"ke");
                        //System.out.println(canMoveX.get(i)+"ke");
                        //System.out.println(canMoveY.get(i).get(q)+"ke");
                        //System.out.println(canMoveX.get(i).get(q)+"ke");
                        Enemy.add(getRank(canMoveY.get(i).get(q) , canMoveX.get(i).get(q), charBoard));
                        Eat.add(getImportance(canMoveY.get(i).get(q) , canMoveX.get(i).get(q), charBoard));
                            int temp = Eat.get(0) + 100;
                            if (temp > step) {
                                step = temp;
                            }
                        else {
                             temp = -1;
                            if (step >= 10000) {
                            } else {
                                step = temp;
                            }
                        }
                    }
                    System.out.println(step+"ke");
                    value.add(step);}
            StepsValue.add(value);}

        return StepsValue;}}








