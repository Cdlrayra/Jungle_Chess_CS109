package model;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import view.*;

public class charBoard {
    public static char[][] charBoard = new char[9][7];
    private static int currentPlayer=2;//1:红方玩家；2：蓝方玩家
    private static int choosePlayer;
    public static int Rounds = 1;//当前回合数
    private static char firstChoose ;

    public static int getCurrentPlayer() {
        return currentPlayer;
    }

    private static boolean isChooseRight;
    private static boolean isChooseRight_2;
    public static void setLastPar(){
        Rounds--;
        if(Rounds%2==1){
            currentPlayer=2;
        }else {
            currentPlayer=1;
        }
    }
    public static void readLastBoard() {
        if (Rounds == 1) {
        } else {
            File file = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//Files//chessboard");
            FileReader fileReader;
            try {
                fileReader = new FileReader(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            StringBuilder str = new StringBuilder();
            int len = 0;
            try {
                len = (int) fileReader.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            while (len != -1) {
                str.append((char) len);
                try {
                    len = (int) fileReader.read();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            String newStr = str.toString();
            String targetStr = newStr.replaceAll("\\s*", "");
            List<String> stringList = new ArrayList<>();
            String temp;
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < Rounds - 1; i++) {
                temp = targetStr.substring(i * 68, i * 68 + 1);
                stringList.add(temp);
                System.out.println(temp);
                for (int j = 0; j < 9; j++) {
                    temp = targetStr.substring(i * 68 + 7 * j + 1, i * 68 + 7 * j + 1 + 7);
                    stringList.add(temp);
                    System.out.println(temp);
                }
                temp = targetStr.substring(i * 68 + 64, i * 68 + 68);
                stringList.add(temp);
                System.out.println(temp);
            }
            for (String rewriteStr : stringList) {
                stringBuffer.append(rewriteStr);
                System.out.println(rewriteStr);
                stringBuffer.append("\n");
            }

            FileWriter fileWriter;
            try {
                fileWriter = new FileWriter(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                fileWriter.write(stringBuffer.toString().toCharArray());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void readChessBoard() {
        if (Rounds == 0) {
            charBoard = new char[][]{
                    {'I', '0', '0', '0', '0', '0', 'T'},
                    {'0', 'D', '0', '0', '0', 'C', '0'},
                    {'R', '0', 'L', '0', 'W', '0', 'E'},
                    {'0', '0', '0', '0', '0', '0', '0'},
                    {'0', '0', '0', '0', '0', '0', '0'},
                    {'0', '0', '0', '0', '0', '0', '0'},
                    {'e', '0', 'w', '0', 'l', '0', 'r'},
                    {'0', 'c', '0', '0', '0', 'd', '0'},
                    {'t', '0', '0', '0', '0', '0', 'i'}
            };
        } else {
            File file = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//Files//chessboard");
            FileReader fileReader;
            try {
                fileReader = new FileReader(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            StringBuilder str = new StringBuilder();
            int len = 0;
            try {
                len = (int) fileReader.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            while (len != -1) {
                str.append((char) len);
                try {
                    len = (int) fileReader.read();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            String newStr = str.toString();
            String targetStr = newStr.replaceAll("\\s*", "");
            int first = 68 * (Rounds - 1) + 1;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 7; j++) {
                    charBoard[i][j] = targetStr.charAt(first);
                    first++;
                    System.out.print(charBoard[i][j]);
                }
                System.out.println();
            }
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static char[][] getCharBoard() {
        return charBoard;
    }

    public static boolean setFirstChoose(){
        firstChoose=charBoard[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf];
        if(firstChoose=='0'){isChooseRight=false;}
        else {
            if('a'<=firstChoose&&firstChoose<='z'){
                choosePlayer=2;
                if(choosePlayer==currentPlayer){
                    isChooseRight=true;
                }else {isChooseRight=false;}
            }
            else {
                choosePlayer=1;
                if (choosePlayer == currentPlayer) {
                    isChooseRight = true;
                } else {
                    isChooseRight = false;
                }
            }
        }
        return isChooseRight;
    }
    public static boolean setSecondChoose(){
        for (int i = 0; i < 4; i++) {
            if(GameFrame.black_select_y_conf_2==pieceBoard.pos[i][0]&&GameFrame.black_select_x_conf_2==pieceBoard.pos[i][1]){
                isChooseRight_2=true;
                break;
            }
            if(i==3){isChooseRight_2=false;}
        }
        return isChooseRight_2;
    }
    public static void setNextCurrentPlayer(){
        Rounds++;
        if(Rounds%2==1){
            currentPlayer=2;
        }else {
            currentPlayer=1;
        }
    }
    public static void setCharBoard_restart(){
        Rounds=0;
    }
    public static void writeChessboard() throws IOException {
        int output = Rounds%10;
        File addUser = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//Files//chessboard");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(addUser,true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.write(output+"\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 7; j++) {
                    fileWriter.write(charBoard[i][j]+"");
                }fileWriter.write("\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileWriter.write(pieceBoard.y_1+"");
        fileWriter.write(pieceBoard.x_1+"");
        fileWriter.write(pieceBoard.y_2+"");
        fileWriter.write(pieceBoard.x_2+"");
        fileWriter.write("\n");
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //todo:添加改动棋子的位置
    }
    public static void writeChessboardS() throws IOException {
        int output = Rounds%10;
        File addUser = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//Files//chessboard(server)");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(addUser,true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.write(output+"\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 7; j++) {
                    fileWriter.write(charBoard[i][j]+"");
                }fileWriter.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileWriter.write(pieceBoard.y_1+"");
        fileWriter.write(pieceBoard.x_1+"");
        fileWriter.write(pieceBoard.y_2+"");
        fileWriter.write(pieceBoard.x_2+"");
        fileWriter.write("\n");
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //todo:添加改动棋子的位置
    }
    public static void writeChessboardC() throws IOException {
        int output = Rounds%10;
        File addUser = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//Files//chessboard(client)");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(addUser,true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.write(output+"\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 7; j++) {
                    fileWriter.write(charBoard[i][j]+"");
                }fileWriter.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileWriter.write(pieceBoard.y_1+"");
        fileWriter.write(pieceBoard.x_1+"");
        fileWriter.write(pieceBoard.y_2+"");
        fileWriter.write(pieceBoard.x_2+"");
        fileWriter.write("\n");
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //todo:添加改动棋子的位置
    }
    public static void readChessBoardS(){
        if (Rounds == 0) {
            charBoard = new char[][]{
                    {'I', '0', '0', '0', '0', '0', 'T'},
                    {'0', 'D', '0', '0', '0', 'C', '0'},
                    {'R', '0', 'L', '0', 'W', '0', 'E'},
                    {'0', '0', '0', '0', '0', '0', '0'},
                    {'0', '0', '0', '0', '0', '0', '0'},
                    {'0', '0', '0', '0', '0', '0', '0'},
                    {'e', '0', 'w', '0', 'l', '0', 'r'},
                    {'0', 'c', '0', '0', '0', 'd', '0'},
                    {'t', '0', '0', '0', '0', '0', 'i'}
            };
        } else {
            File file = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//Files//chessboard(server)");
            FileReader fileReader;
            try {
                fileReader = new FileReader(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            StringBuilder str = new StringBuilder();
            int len = 0;
            try {
                len = (int) fileReader.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            while (len != -1) {
                str.append((char) len);
                try {
                    len = (int) fileReader.read();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            String newStr = str.toString();
            String targetStr = newStr.replaceAll("\\s*", "");
            int first = 68 * (Rounds - 1) + 1 ;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 7; j++) {
                    charBoard[i][j] = targetStr.charAt(first);
                    first++;
                    System.out.print(charBoard[i][j]);
                }
                System.out.println();
            }
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void readChessBoardC(){
        if (Rounds == 0) {
            charBoard = new char[][]{
                    {'I', '0', '0', '0', '0', '0', 'T'},
                    {'0', 'D', '0', '0', '0', 'C', '0'},
                    {'R', '0', 'L', '0', 'W', '0', 'E'},
                    {'0', '0', '0', '0', '0', '0', '0'},
                    {'0', '0', '0', '0', '0', '0', '0'},
                    {'0', '0', '0', '0', '0', '0', '0'},
                    {'e', '0', 'w', '0', 'l', '0', 'r'},
                    {'0', 'c', '0', '0', '0', 'd', '0'},
                    {'t', '0', '0', '0', '0', '0', 'i'}
            };
        } else {
            File file = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//Files//chessboard(client)");
            FileReader fileReader;
            try {
                fileReader = new FileReader(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            StringBuilder str = new StringBuilder();
            int len = 0;
            try {
                len = (int) fileReader.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            while (len != -1) {
                str.append((char) len);
                try {
                    len = (int) fileReader.read();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            String newStr = str.toString();
            String targetStr = newStr.replaceAll("\\s*", "");
            int first = 68 * (Rounds - 1) + 1 ;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 7; j++) {
                    charBoard[i][j] = targetStr.charAt(first);
                    first++;
                    System.out.print(charBoard[i][j]);
                }
                System.out.println();
            }
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void main(String[] args) {
        charBoard = new char[][]{
                {'I', '0', '0', '0', '0', '0', 'T'},
                {'0', 'D', '0', '0', '0', 'C', '0'},
                {'R', '0', 'L', '0', 'W', '0', 'E'},
                {'0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0'},
                {'e', '0', 'w', '0', 'l', '0', 'r'},
                {'0', 'c', '0', '0', '0', 'd', '0'},
                {'t', '0', '0', '0', '0', '0', 'i'}
        };
        try {
            writeChessboard();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}