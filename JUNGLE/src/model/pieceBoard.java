package model;
import view.*;
public class pieceBoard {
    public static Pieces[][] piece_Board = new Pieces[9][7];
    public static int[][] pos = new int[][]{{-4,-4},{-4,-4},{-4,-4},{-4,-4}};
    public static int  count = 0;
    public static int y_1=0;
    public static int x_1=0;
    public static int y_2=0;
    public static int x_2=0;
    public static void deleteBoard(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++) {
                piece_Board[i][j]=null;
            }
        }
    }
    public static void writeBoard(){//写入棋盘改变的棋盘
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++) {
                if(piece_Board[i][j]==null){charBoard.charBoard[i][j]='0';continue;}
                if(piece_Board[i][j].getName()=='R'){charBoard.charBoard[i][j]='R';continue;}
                if(piece_Board[i][j].getName()=='r'){charBoard.charBoard[i][j]='r';continue;}
                if(piece_Board[i][j].getName()=='C'){charBoard.charBoard[i][j]='C';continue;}
                if(piece_Board[i][j].getName()=='c'){charBoard.charBoard[i][j]='c';continue;}
                if(piece_Board[i][j].getName()=='D'){charBoard.charBoard[i][j]='D';continue;}
                if(piece_Board[i][j].getName()=='d'){charBoard.charBoard[i][j]='d';continue;}
                if(piece_Board[i][j].getName()=='W'){charBoard.charBoard[i][j]='W';continue;}
                if(piece_Board[i][j].getName()=='w'){charBoard.charBoard[i][j]='w';continue;}
                if(piece_Board[i][j].getName()=='L'){charBoard.charBoard[i][j]='L';continue;}
                if(piece_Board[i][j].getName()=='l'){charBoard.charBoard[i][j]='l';continue;}
                if(piece_Board[i][j].getName()=='T'){charBoard.charBoard[i][j]='T';continue;}
                if(piece_Board[i][j].getName()=='t'){charBoard.charBoard[i][j]='t';continue;}
                if(piece_Board[i][j].getName()=='I'){charBoard.charBoard[i][j]='I';continue;}
                if(piece_Board[i][j].getName()=='i'){charBoard.charBoard[i][j]='i';continue;}
                if(piece_Board[i][j].getName()=='E'){charBoard.charBoard[i][j]='E';continue;}
                if(piece_Board[i][j].getName()=='e'){charBoard.charBoard[i][j]='e';}
            }
        }

    }
    public static void readBoard() {//读入存在文件中的棋盘
        deleteBoard();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++) {
                if (charBoard.charBoard[i][j] != '0') {
                    if ((i == 0 && j == 2) || (i == 0 && j == 4) || (i == 8 && j == 2) || (i == 8 && j == 4)||(i==1&&j==3)||(i==7&&j==3)) {//棋子在陷阱中
                        if (charBoard.charBoard[i][j] == 'R' && ((i == 0 && j == 2) || (i == 0 && j == 4)||(i==1&&j==3))) {
                            piece_Board[i][j] = new Pieces(1, 'R', 1);
                        } else if (charBoard.charBoard[i][j] == 'R') {
                            piece_Board[i][j] = new Pieces(1, 'R', 0);
                            System.out.println("进入陷阱");
                        }
                        if (charBoard.charBoard[i][j] == 'r' && ((i == 8 && j == 2) || (i == 8 && j == 4)||(i==7&&j==3))) {
                            piece_Board[i][j] = new Pieces(2, 'r', 1);
                        } else if (charBoard.charBoard[i][j] == 'r') {
                            piece_Board[i][j] = new Pieces(2, 'r', 0);
                            System.out.println("进入陷阱");
                        }
                        if (charBoard.charBoard[i][j] == 'C' && ((i == 0 && j == 2) || (i == 0 && j == 4)||(i==1&&j==3))) {
                            piece_Board[i][j] = new Pieces(1, 'C', 2);
                        } else if (charBoard.charBoard[i][j] == 'C') {
                            piece_Board[i][j] = new Pieces(1, 'C', 0);
                            System.out.println("进入陷阱");
                        }
                        if (charBoard.charBoard[i][j] == 'c' && ((i == 8 && j == 2) || (i == 8 && j == 4)||(i==7&&j==3))) {
                            piece_Board[i][j] = new Pieces(2, 'c', 2);
                        } else if (charBoard.charBoard[i][j] == 'c') {
                            piece_Board[i][j] = new Pieces(2, 'c', 0);
                            System.out.println("进入陷阱");
                        }
                        if (charBoard.charBoard[i][j] == 'D' && ((i == 0 && j == 2) || (i == 0 && j == 4)||(i==1&&j==3))) {
                            piece_Board[i][j] = new Pieces(1, 'D', 3);
                        } else if (charBoard.charBoard[i][j] == 'D') {
                            piece_Board[i][j] = new Pieces(1, 'D', 0);
                            System.out.println("进入陷阱");
                        }
                        if (charBoard.charBoard[i][j] == 'd' && ((i == 8 && j == 2) || (i == 8 && j == 4)||(i==7&&j==3))) {
                            piece_Board[i][j] = new Pieces(2, 'd', 3);
                        } else if (charBoard.charBoard[i][j] == 'd') {
                            piece_Board[i][j] = new Pieces(2, 'd', 0);
                            System.out.println("进入陷阱");
                        }
                        if (charBoard.charBoard[i][j] == 'W' && ((i == 0 && j == 2) || (i == 0 && j == 4)||(i==1&&j==3))) {
                            piece_Board[i][j] = new Pieces(1, 'W', 4);
                        } else if (charBoard.charBoard[i][j] == 'W') {
                            piece_Board[i][j] = new Pieces(1, 'W', 0);
                            System.out.println("进入陷阱");
                        }
                        if (charBoard.charBoard[i][j] == 'w' && ((i == 8 && j == 2) || (i == 8 && j == 4)||(i==7&&j==3))) {
                            piece_Board[i][j] = new Pieces(2, 'w', 4);
                        } else if (charBoard.charBoard[i][j] == 'w') {
                            piece_Board[i][j] = new Pieces(2, 'w', 0);
                            System.out.println("进入陷阱");
                        }
                        if (charBoard.charBoard[i][j] == 'L' && ((i == 0 && j == 2) || (i == 0 && j == 4)||(i==1&&j==3))) {
                            piece_Board[i][j] = new Pieces(1, 'L', 5);
                        } else if (charBoard.charBoard[i][j] == 'L') {
                            piece_Board[i][j] = new Pieces(1, 'L', 0);
                            System.out.println("进入陷阱");
                        }
                        if (charBoard.charBoard[i][j] == 'l' && ((i == 8 && j == 2) || (i == 8 && j == 4)||(i==7&&j==3))) {
                            piece_Board[i][j] = new Pieces(2, 'l', 5);
                        } else if (charBoard.charBoard[i][j] == 'l') {
                            piece_Board[i][j] = new Pieces(2, 'l', 0);
                            System.out.println("进入陷阱");
                        }
                        if (charBoard.charBoard[i][j] == 'T' && ((i == 0 && j == 2) || (i == 0 && j == 4)||(i==1&&j==3))) {
                            piece_Board[i][j] = new Pieces(1, 'T', 6);
                        } else if (charBoard.charBoard[i][j] == 'T') {
                            piece_Board[i][j] = new Pieces(1, 'T', 0);
                            System.out.println("进入陷阱");
                        }
                        if (charBoard.charBoard[i][j] == 't' && ((i == 8 && j == 2) || (i == 8 && j == 4)||(i==7&&j==3))) {
                            piece_Board[i][j] = new Pieces(2, 't', 6);
                        } else if (charBoard.charBoard[i][j] == 't') {
                            piece_Board[i][j] = new Pieces(2, 't', 0);
                            System.out.println("进入陷阱");
                        }
                        if (charBoard.charBoard[i][j] == 'I' && ((i == 0 && j == 2) || (i == 0 && j == 4)||(i==1&&j==3))) {
                            piece_Board[i][j] = new Pieces(1, 'I', 7);
                        } else if (charBoard.charBoard[i][j] == 'I') {
                            piece_Board[i][j] = new Pieces(1, 'I', 0);
                            System.out.println("进入陷阱");
                        }
                        if (charBoard.charBoard[i][j] == 'i' && ((i == 8 && j == 2) || (i == 8 && j == 4)||(i==7&&j==3))) {
                            piece_Board[i][j] = new Pieces(2, 'i', 7);
                        } else if (charBoard.charBoard[i][j] == 'i') {
                            piece_Board[i][j] = new Pieces(2, 'i', 0);
                            System.out.println("进入陷阱");
                        }
                        if (charBoard.charBoard[i][j] == 'E' && ((i == 0 && j == 2) || (i == 0 && j == 4)||(i==1&&j==3))) {
                            piece_Board[i][j] = new Pieces(1, 'E', 8);
                        } else if (charBoard.charBoard[i][j] == 'E') {
                            piece_Board[i][j] = new Pieces(1, 'E', 0);
                            System.out.println("进入陷阱");
                        }
                        if (charBoard.charBoard[i][j] == 'e' && ((i == 8 && j == 2) || (i == 8 && j == 4)||(i==7&&j==3))) {
                            piece_Board[i][j] = new Pieces(2, 'e', 8);
                        } else if (charBoard.charBoard[i][j] == 'e') {
                            piece_Board[i][j] = new Pieces(2, 'e', 0);
                            System.out.println("进入陷阱");
                        }
                    } else { //棋子不在陷阱中
                        if (charBoard.charBoard[i][j] == 'R') {
                            piece_Board[i][j] = new Pieces(1, 'R', 1);
                        }
                        if (charBoard.charBoard[i][j] == 'r') {
                            piece_Board[i][j] = new Pieces(2, 'r', 1);
                        }
                        if (charBoard.charBoard[i][j] == 'C') {
                            piece_Board[i][j] = new Pieces(1, 'C', 2);
                        }
                        if (charBoard.charBoard[i][j] == 'c') {
                            piece_Board[i][j] = new Pieces(2, 'c', 2);
                        }
                        if (charBoard.charBoard[i][j] == 'D') {
                            piece_Board[i][j] = new Pieces(1, 'D', 3);
                        }
                        if (charBoard.charBoard[i][j] == 'd') {
                            piece_Board[i][j] = new Pieces(2, 'd', 3);
                        }
                        if (charBoard.charBoard[i][j] == 'W') {
                            piece_Board[i][j] = new Pieces(1, 'W', 4);
                        }
                        if (charBoard.charBoard[i][j] == 'w') {
                            piece_Board[i][j] = new Pieces(2, 'w', 4);
                        }
                        if (charBoard.charBoard[i][j] == 'L') {
                            piece_Board[i][j] = new Pieces(1, 'L', 5);
                        }
                        if (charBoard.charBoard[i][j] == 'l') {
                            piece_Board[i][j] = new Pieces(2, 'l', 5);
                        }
                        if (charBoard.charBoard[i][j] == 'T') {
                            piece_Board[i][j] = new Pieces(1, 'T', 6);
                        }
                        if (charBoard.charBoard[i][j] == 't') {
                            piece_Board[i][j] = new Pieces(2, 't', 6);
                        }
                        if (charBoard.charBoard[i][j] == 'I') {
                            piece_Board[i][j] = new Pieces(1, 'I', 7);
                        }
                        if (charBoard.charBoard[i][j] == 'i') {
                            piece_Board[i][j] = new Pieces(2, 'i', 7);
                        }
                        if (charBoard.charBoard[i][j] == 'E') {
                            piece_Board[i][j] = new Pieces(1, 'E', 8);
                        }
                        if (charBoard.charBoard[i][j] == 'e') {
                            piece_Board[i][j] = new Pieces(2, 'e', 8);
                        }

                    }
                }
            }
        }
    }
    public static boolean checkWin(){
        if(piece_Board[0][3]!=null||piece_Board[8][3]!=null){
            return true;
        }
        if(!isAlive()){//一方棋子都没了
            return true;
        }
        return false;
    }
    public static boolean isAlive(){//判断是否有一方的棋子都没了
        int isPlayerAlive_1=0;
        int isPlayerAlive_2=0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++) {
                if(piece_Board[i][j]==null){
                    continue;
                }
                if(piece_Board[i][j].getOwner()==1){
                    isPlayerAlive_1++;
                }
                if(piece_Board[i][j].getOwner()==2){
                    isPlayerAlive_2++;
                }
            }
        }
        if(isPlayerAlive_1==0||isPlayerAlive_2==0){
            return false;//有一方没有棋子
        }
        return true;//
    }
    public  static void setPos_Default(){
        count = 0;
        for (int i = 0; i < 4; i++) {
            pos[i][0] = -4;
            pos[i][1] = -4;
        }
    }
    public static void changeBoard(){
        y_2=GameFrame.black_select_y_conf_2;
        x_2=GameFrame.black_select_x_conf_2;
        piece_Board[GameFrame.black_select_y_conf_2][GameFrame.black_select_x_conf_2]=piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf];
        piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf]=null;
    }

    public static void getPos() {
        count = 0;
        for (int i = 0; i < 4; i++) {
            pos[i][0] = -4;
            pos[i][1] = -4;
        }//初始化可能的位置坐标
        Pieces selectPieces = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf];
        y_1=GameFrame.black_select_y_conf;
        x_1=GameFrame.black_select_x_conf;
        if (selectPieces.getRank() != 1 && selectPieces.getRank() != 6 && selectPieces.getRank() != 7&&selectPieces.getRank()!=0) {//非特殊类的棋子走法
            int[][] dir = {{-1, 0, 1, 0}, {0, 1, 0, -1}};
            for (int i = 0; i < 4; i++) {
                if (GameFrame.black_select_y_conf + dir[0][i] >= 0 && GameFrame.black_select_y_conf + dir[0][i] <= 8 &&
                        GameFrame.black_select_x_conf + dir[1][i] >= 0 && GameFrame.black_select_x_conf + dir[1][i] <= 6) {//可能的位置没有超出边界
                    Pieces targetPos = piece_Board[GameFrame.black_select_y_conf + dir[0][i]][GameFrame.black_select_x_conf + dir[1][i]];
                    if ((GameFrame.black_select_y_conf + dir[0][i] == 3 && GameFrame.black_select_x_conf + dir[1][i] == 1) ||
                            (GameFrame.black_select_y_conf + dir[0][i] == 3 && GameFrame.black_select_x_conf + dir[1][i] == 2) ||
                            (GameFrame.black_select_y_conf + dir[0][i] == 3 && GameFrame.black_select_x_conf + dir[1][i] == 4) ||
                            (GameFrame.black_select_y_conf + dir[0][i] == 3 && GameFrame.black_select_x_conf + dir[1][i] == 5) ||
                            (GameFrame.black_select_y_conf + dir[0][i] == 4 && GameFrame.black_select_x_conf + dir[1][i] == 1) ||
                            (GameFrame.black_select_y_conf + dir[0][i] == 4 && GameFrame.black_select_x_conf + dir[1][i] == 2) ||
                            (GameFrame.black_select_y_conf + dir[0][i] == 4 && GameFrame.black_select_x_conf + dir[1][i] == 4) ||
                            (GameFrame.black_select_y_conf + dir[0][i] == 4 && GameFrame.black_select_x_conf + dir[1][i] == 5) ||
                            (GameFrame.black_select_y_conf + dir[0][i] == 5 && GameFrame.black_select_x_conf + dir[1][i] == 1) ||
                            (GameFrame.black_select_y_conf + dir[0][i] == 5 && GameFrame.black_select_x_conf + dir[1][i] == 2) ||
                            (GameFrame.black_select_y_conf + dir[0][i] == 5 && GameFrame.black_select_x_conf + dir[1][i] == 4) ||
                            (GameFrame.black_select_y_conf + dir[0][i] == 5 && GameFrame.black_select_x_conf + dir[1][i] == 5)
                    ) {//可能的位置是河流
                    } else {
                        if (selectPieces.getOwner() == 1) {//红方
                            if ((targetPos == null || selectPieces.isCatch(targetPos))) {
                                if (GameFrame.black_select_y_conf + dir[0][i] == 0 && GameFrame.black_select_x_conf + dir[1][i] == 3) {
                                } else {
                                    pos[count][0] = GameFrame.black_select_y_conf + dir[0][i];
                                    pos[count][1] = GameFrame.black_select_x_conf + dir[1][i];
                                    count++;
                                }
                            }
                        } else {
                            if ((targetPos == null || selectPieces.isCatch(targetPos))) {
                                if (GameFrame.black_select_y_conf + dir[0][i] == 8 && GameFrame.black_select_x_conf + dir[1][i] == 3) {
                                } else {
                                    pos[count][0] = GameFrame.black_select_y_conf + dir[0][i];
                                    pos[count][1] = GameFrame.black_select_x_conf + dir[1][i];
                                    count++;
                                }
                            }

                        }
                    }
                }
            }
        }
        if (selectPieces.getRank() == 6 || selectPieces.getRank() == 7) {//狮子和老虎的走法
            if ((GameFrame.black_select_y_conf == 2 && GameFrame.black_select_x_conf == 1) ||
                    (GameFrame.black_select_y_conf == 2 && GameFrame.black_select_x_conf == 2) || //在河边
                    (GameFrame.black_select_y_conf == 2 && GameFrame.black_select_x_conf == 4) || //在河边
                    (GameFrame.black_select_y_conf == 2 && GameFrame.black_select_x_conf == 5)) {//在河边
                Pieces targetPos_1 = piece_Board[GameFrame.black_select_y_conf - 1][GameFrame.black_select_x_conf];
                if ( targetPos_1 == null||selectPieces.isCatch(targetPos_1) ) {
                    pos[count][0] = GameFrame.black_select_y_conf - 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_2 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1];
                if ( targetPos_2 == null||selectPieces.isCatch(targetPos_2) ) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf + 1;
                    count++;
                }
                Pieces targetPos_3 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1];
                if ( targetPos_3 == null||selectPieces.isCatch(targetPos_3) ) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf - 1;
                    count++;
                }
                Pieces targetPos_4 = piece_Board[GameFrame.black_select_y_conf + 4][GameFrame.black_select_x_conf];
                if ((piece_Board[GameFrame.black_select_y_conf + 1][GameFrame.black_select_x_conf] == null ||
                        piece_Board[GameFrame.black_select_y_conf + 1][GameFrame.black_select_x_conf].getOwner() == selectPieces.getOwner()) &&
                        (piece_Board[GameFrame.black_select_y_conf + 2][GameFrame.black_select_x_conf] == null ||
                                piece_Board[GameFrame.black_select_y_conf + 2][GameFrame.black_select_x_conf].getOwner() == selectPieces.getOwner()) &&
                        (piece_Board[GameFrame.black_select_y_conf + 3][GameFrame.black_select_x_conf] == null ||
                                piece_Board[GameFrame.black_select_y_conf + 3][GameFrame.black_select_x_conf].getOwner() == selectPieces.getOwner())) {
                    if ( targetPos_4 == null||selectPieces.isCatch(targetPos_4) ) {
                        pos[count][0] = GameFrame.black_select_y_conf + 4;
                        pos[count][1] = GameFrame.black_select_x_conf;
                    }
                }
            } else if ((GameFrame.black_select_y_conf == 6 && GameFrame.black_select_x_conf == 1) ||
                    (GameFrame.black_select_y_conf == 6 && GameFrame.black_select_x_conf == 2) || //在河边
                    (GameFrame.black_select_y_conf == 6 && GameFrame.black_select_x_conf == 4) || //在河边
                    (GameFrame.black_select_y_conf == 6 && GameFrame.black_select_x_conf == 5)) {
                Pieces targetPos_1 = piece_Board[GameFrame.black_select_y_conf + 1][GameFrame.black_select_x_conf];
                if ( targetPos_1 == null||selectPieces.isCatch(targetPos_1) ) {
                    pos[count][0] = GameFrame.black_select_y_conf + 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_2 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1];
                if ( targetPos_2 == null||selectPieces.isCatch(targetPos_2) ) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf + 1;
                    count++;
                }
                Pieces targetPos_3 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1];
                if ( targetPos_3 == null||selectPieces.isCatch(targetPos_3) ) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf - 1;
                    count++;
                }
                Pieces targetPos_4 = piece_Board[GameFrame.black_select_y_conf - 4][GameFrame.black_select_x_conf];
                if ((piece_Board[GameFrame.black_select_y_conf - 1][GameFrame.black_select_x_conf] == null ||
                        piece_Board[GameFrame.black_select_y_conf - 1][GameFrame.black_select_x_conf].getOwner() == selectPieces.getOwner()) &&
                        (piece_Board[GameFrame.black_select_y_conf - 2][GameFrame.black_select_x_conf] == null ||
                                piece_Board[GameFrame.black_select_y_conf - 2][GameFrame.black_select_x_conf].getOwner() == selectPieces.getOwner()) &&
                        (piece_Board[GameFrame.black_select_y_conf - 3][GameFrame.black_select_x_conf] == null ||
                                piece_Board[GameFrame.black_select_y_conf - 3][GameFrame.black_select_x_conf].getOwner() == selectPieces.getOwner())) {
                    if ( targetPos_4 == null||selectPieces.isCatch(targetPos_4) ) {
                        pos[count][0] = GameFrame.black_select_y_conf - 4;
                        pos[count][1] = GameFrame.black_select_x_conf;
                    }
                }
            } else if ((GameFrame.black_select_y_conf == 3 && GameFrame.black_select_x_conf == 0) ||
                    (GameFrame.black_select_y_conf == 4 && GameFrame.black_select_x_conf == 0) || //在河边
                    (GameFrame.black_select_y_conf == 5 && GameFrame.black_select_x_conf == 0)) {
                Pieces targetPos_1 = piece_Board[GameFrame.black_select_y_conf + 1][GameFrame.black_select_x_conf];
                if (  targetPos_1 == null||selectPieces.isCatch(targetPos_1) ) {
                    pos[count][0] = GameFrame.black_select_y_conf + 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_2 = piece_Board[GameFrame.black_select_y_conf - 1][GameFrame.black_select_x_conf];
                if (  targetPos_2 == null||selectPieces.isCatch(targetPos_2) ) {
                    pos[count][0] = GameFrame.black_select_y_conf - 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_3 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 3];
                if ((piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1] == null ||
                        piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1].getOwner() == selectPieces.getOwner()) &&
                        (piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 2] == null ||
                                piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 2].getOwner() == selectPieces.getOwner())) {
                    if ( targetPos_3 == null||selectPieces.isCatch(targetPos_3) ) {
                        pos[count][0] = GameFrame.black_select_y_conf;
                        pos[count][1] = GameFrame.black_select_x_conf + 3;
                    }
                }
            } else if ((GameFrame.black_select_y_conf == 3 && GameFrame.black_select_x_conf == 3) ||
                    (GameFrame.black_select_y_conf == 4 && GameFrame.black_select_x_conf == 3) || //在河边
                    (GameFrame.black_select_y_conf == 5 && GameFrame.black_select_x_conf == 3)) {
                Pieces targetPos_1 = piece_Board[GameFrame.black_select_y_conf + 1][GameFrame.black_select_x_conf];
                if ( targetPos_1 == null||selectPieces.isCatch(targetPos_1) ) {
                    pos[count][0] = GameFrame.black_select_y_conf + 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_2 = piece_Board[GameFrame.black_select_y_conf - 1][GameFrame.black_select_x_conf];
                if ( targetPos_2 == null||selectPieces.isCatch(targetPos_2) ) {
                    pos[count][0] = GameFrame.black_select_y_conf - 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_3 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 3];
                if ((piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1] == null ||
                        piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1].getOwner() == selectPieces.getOwner()) &&
                        (piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 2] == null ||
                                piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 2].getOwner() == selectPieces.getOwner())) {
                    if (  targetPos_3 == null||selectPieces.isCatch(targetPos_3) ) {
                        pos[count][0] = GameFrame.black_select_y_conf;
                        pos[count][1] = GameFrame.black_select_x_conf + 3;
                        count++;
                    }
                }
                Pieces targetPos_4 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 3];
                if ((piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1] == null ||
                        piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1].getOwner() == selectPieces.getOwner()) &&
                        (piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 2] == null ||
                                piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 2].getOwner() == selectPieces.getOwner())) {
                    if (  targetPos_4 == null||selectPieces.isCatch(targetPos_4) ) {
                        pos[count][0] = GameFrame.black_select_y_conf;
                        pos[count][1] = GameFrame.black_select_x_conf - 3;
                    }
                }

            } else if ((GameFrame.black_select_y_conf == 3 && GameFrame.black_select_x_conf == 6) ||
                    (GameFrame.black_select_y_conf == 4 && GameFrame.black_select_x_conf == 6) || //在河边
                    (GameFrame.black_select_y_conf == 5 && GameFrame.black_select_x_conf == 6)) {
                Pieces targetPos_2 = piece_Board[GameFrame.black_select_y_conf + 1][GameFrame.black_select_x_conf];
                if ( targetPos_2 == null||selectPieces.isCatch(targetPos_2) ) {
                    pos[count][0] = GameFrame.black_select_y_conf + 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_3 = piece_Board[GameFrame.black_select_y_conf - 1][GameFrame.black_select_x_conf];
                if ( targetPos_3 == null||selectPieces.isCatch(targetPos_3) ) {
                    pos[count][0] = GameFrame.black_select_y_conf - 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_4 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 3];
                if ((piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1] == null ||
                        piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1].getOwner() == selectPieces.getOwner()) &&
                        (piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 2] == null ||
                                piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 2].getOwner() == selectPieces.getOwner())) {
                    if ( targetPos_4 == null||selectPieces.isCatch(targetPos_4) ) {
                        pos[count][0] = GameFrame.black_select_y_conf;
                        pos[count][1] = GameFrame.black_select_x_conf - 3;
                    }
                }
            } else {//不在河边
                int[][] dir = {{-1, 0, 1, 0}, {0, 1, 0, -1}};
                for (int i = 0; i < 4; i++) {
                    if (GameFrame.black_select_y_conf + dir[0][i] >= 0 && GameFrame.black_select_y_conf + dir[0][i] <= 8 &&
                            GameFrame.black_select_x_conf + dir[1][i] >= 0 && GameFrame.black_select_x_conf + dir[1][i] <= 6) {//可能的位置是合理的
                        Pieces targetPos = piece_Board[GameFrame.black_select_y_conf + dir[0][i]][GameFrame.black_select_x_conf + dir[1][i]];
                        if (selectPieces.getOwner() == 1) {//红方
                            if ((targetPos == null || selectPieces.isCatch(targetPos))) {
                                if (GameFrame.black_select_y_conf + dir[0][i] == 0 && GameFrame.black_select_x_conf + dir[1][i] == 3) {
                                } else {
                                    pos[count][0] = GameFrame.black_select_y_conf + dir[0][i];
                                    pos[count][1] = GameFrame.black_select_x_conf + dir[1][i];
                                    count++;
                                }
                            }
                        } else {
                            if ((targetPos == null || selectPieces.isCatch(targetPos))) {
                                if (GameFrame.black_select_y_conf + dir[0][i] == 8 && GameFrame.black_select_x_conf + dir[1][i] == 3) {
                                } else {
                                    pos[count][0] = GameFrame.black_select_y_conf + dir[0][i];
                                    pos[count][1] = GameFrame.black_select_x_conf + dir[1][i];
                                    count++;
                                }
                            }

                        }
                    }
                }


            }
        }
        if (selectPieces.getRank() == 1) {//老鼠的走法
            System.out.println("选中棋子为老鼠");
            if(GameFrame.black_select_y_conf==3&&GameFrame.black_select_x_conf==1){//老鼠在河里
                System.out.println("3,1");
                Pieces targetPos_1 = piece_Board[GameFrame.black_select_y_conf + 1][GameFrame.black_select_x_conf];
                if ( targetPos_1 == null||selectPieces.isCatch(targetPos_1) ) {
                    pos[count][0] = GameFrame.black_select_y_conf + 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_2 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1];
                if ( targetPos_2 == null||selectPieces.isCatch(targetPos_2) ) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf + 1;
                    count++;
                }
                Pieces targetPos_3 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1];
                if (targetPos_3 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf - 1;
                    count++;
                }
                Pieces targetPos_4 = piece_Board[GameFrame.black_select_y_conf - 1][GameFrame.black_select_x_conf];
                if ( targetPos_4 == null) {
                        pos[count][0] = GameFrame.black_select_y_conf - 1;
                        pos[count][1] = GameFrame.black_select_x_conf;
                    }
                }
            else if(GameFrame.black_select_y_conf==3&&GameFrame.black_select_x_conf==2){
                System.out.println("3,2");
                Pieces targetPos_1 = piece_Board[GameFrame.black_select_y_conf + 1][GameFrame.black_select_x_conf];
                if ( targetPos_1 == null||selectPieces.isCatch(targetPos_1) ) {
                    pos[count][0] = GameFrame.black_select_y_conf + 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_2 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1];
                if ( targetPos_2 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf + 1;
                    count++;
                }
                Pieces targetPos_3 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1];
                if ( targetPos_3 == null||selectPieces.isCatch(targetPos_3) ) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf - 1;
                    count++;
                }
                Pieces targetPos_4 = piece_Board[GameFrame.black_select_y_conf - 1][GameFrame.black_select_x_conf];
                if ( targetPos_4 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf - 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                }
            }
            else if(GameFrame.black_select_y_conf==3&&GameFrame.black_select_x_conf==4){
                System.out.println("3,4");
                Pieces targetPos_1 = piece_Board[GameFrame.black_select_y_conf + 1][GameFrame.black_select_x_conf];
                if ( targetPos_1 == null||selectPieces.isCatch(targetPos_1) ) {
                    pos[count][0] = GameFrame.black_select_y_conf + 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_2 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1];
                if ( targetPos_2 == null||selectPieces.isCatch(targetPos_2) ) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf + 1;
                    count++;
                }
                Pieces targetPos_3 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1];
                if ( targetPos_3 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf - 1;
                    count++;
                }
                Pieces targetPos_4 = piece_Board[GameFrame.black_select_y_conf - 1][GameFrame.black_select_x_conf];
                if ( targetPos_4 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf - 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                }
            }
            else if(GameFrame.black_select_y_conf==3&&GameFrame.black_select_x_conf==5){
                System.out.println("3,5");
                Pieces targetPos_1 = piece_Board[GameFrame.black_select_y_conf + 1][GameFrame.black_select_x_conf];
                if ( targetPos_1 == null||selectPieces.isCatch(targetPos_1) ) {
                    pos[count][0] = GameFrame.black_select_y_conf + 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_2 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1];
                if ( targetPos_2 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf + 1;
                    count++;
                }
                Pieces targetPos_3 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1];
                if ( targetPos_3 == null||selectPieces.isCatch(targetPos_3) ) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf - 1;
                    count++;
                }
                Pieces targetPos_4 = piece_Board[GameFrame.black_select_y_conf - 1][GameFrame.black_select_x_conf];
                if ( targetPos_4 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf - 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                }
            }
            else if(GameFrame.black_select_y_conf==4&&GameFrame.black_select_x_conf==1){
                System.out.println("4,1");
                Pieces targetPos_1 = piece_Board[GameFrame.black_select_y_conf + 1][GameFrame.black_select_x_conf];
                if ( targetPos_1 == null||selectPieces.isCatch(targetPos_1) ) {
                    pos[count][0] = GameFrame.black_select_y_conf + 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_2 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1];
                if ( targetPos_2 == null||selectPieces.isCatch(targetPos_2) ) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf + 1;
                    count++;
                }
                Pieces targetPos_3 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1];
                if ( targetPos_3 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf - 1;
                    count++;
                }
                Pieces targetPos_4 = piece_Board[GameFrame.black_select_y_conf - 1][GameFrame.black_select_x_conf];
                if ( targetPos_4 == null||selectPieces.isCatch(targetPos_4) ) {
                    pos[count][0] = GameFrame.black_select_y_conf - 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                }
            }
            else if(GameFrame.black_select_y_conf==4&&GameFrame.black_select_x_conf==2){
                Pieces targetPos_1 = piece_Board[GameFrame.black_select_y_conf + 1][GameFrame.black_select_x_conf];
                if ( targetPos_1 == null||selectPieces.isCatch(targetPos_1) ) {
                    pos[count][0] = GameFrame.black_select_y_conf + 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_2 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1];
                if ( targetPos_2 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf + 1;
                    count++;
                }
                Pieces targetPos_3 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1];
                if ( targetPos_3 == null||selectPieces.isCatch(targetPos_3) ) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf - 1;
                    count++;
                }
                Pieces targetPos_4 = piece_Board[GameFrame.black_select_y_conf - 1][GameFrame.black_select_x_conf];
                if ( targetPos_4 == null||selectPieces.isCatch(targetPos_4) ) {
                    pos[count][0] = GameFrame.black_select_y_conf - 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                }
            }
            else if(GameFrame.black_select_y_conf==4&&GameFrame.black_select_x_conf==4){
                Pieces targetPos_1 = piece_Board[GameFrame.black_select_y_conf + 1][GameFrame.black_select_x_conf];
                if ( targetPos_1 == null||selectPieces.isCatch(targetPos_1) ) {
                    pos[count][0] = GameFrame.black_select_y_conf + 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_2 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1];
                if ( targetPos_2 == null||selectPieces.isCatch(targetPos_2) ) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf + 1;
                    count++;
                }
                Pieces targetPos_3 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1];
                if ( targetPos_3 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf - 1;
                    count++;
                }
                Pieces targetPos_4 = piece_Board[GameFrame.black_select_y_conf - 1][GameFrame.black_select_x_conf];
                if ( targetPos_4 == null||selectPieces.isCatch(targetPos_4)) {
                    pos[count][0] = GameFrame.black_select_y_conf - 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                }
            }
            else if(GameFrame.black_select_y_conf==4&&GameFrame.black_select_x_conf==5){
                Pieces targetPos_1 = piece_Board[GameFrame.black_select_y_conf + 1][GameFrame.black_select_x_conf];
                if ( targetPos_1 == null||selectPieces.isCatch(targetPos_1)) {
                    pos[count][0] = GameFrame.black_select_y_conf + 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_2 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1];
                if ( targetPos_2 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf + 1;
                    count++;
                }
                Pieces targetPos_3 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1];
                if ( targetPos_3 == null||selectPieces.isCatch(targetPos_3) ) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf - 1;
                    count++;
                }
                Pieces targetPos_4 = piece_Board[GameFrame.black_select_y_conf - 1][GameFrame.black_select_x_conf];
                if ( targetPos_4 == null||selectPieces.isCatch(targetPos_4) ) {
                    pos[count][0] = GameFrame.black_select_y_conf - 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                }
            }
            else if(GameFrame.black_select_y_conf==5&&GameFrame.black_select_x_conf==1){
                Pieces targetPos_1 = piece_Board[GameFrame.black_select_y_conf + 1][GameFrame.black_select_x_conf];
                if ( targetPos_1 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf + 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_2 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1];
                if ( targetPos_2 == null||selectPieces.isCatch(targetPos_2) ) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf + 1;
                    count++;
                }
                Pieces targetPos_3 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1];
                if ( targetPos_3 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf - 1;
                    count++;
                }
                Pieces targetPos_4 = piece_Board[GameFrame.black_select_y_conf - 1][GameFrame.black_select_x_conf];
                if ( targetPos_4 == null||selectPieces.isCatch(targetPos_4) ) {
                    pos[count][0] = GameFrame.black_select_y_conf - 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                }
            }
            else if(GameFrame.black_select_y_conf==5&&GameFrame.black_select_x_conf==2){
                Pieces targetPos_1 = piece_Board[GameFrame.black_select_y_conf + 1][GameFrame.black_select_x_conf];
                if ( targetPos_1 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf + 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_2 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1];
                if ( targetPos_2 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf + 1;
                    count++;
                }
                Pieces targetPos_3 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1];
                if ( targetPos_3 == null||selectPieces.isCatch(targetPos_3) ) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf - 1;
                    count++;
                }
                Pieces targetPos_4 = piece_Board[GameFrame.black_select_y_conf - 1][GameFrame.black_select_x_conf];
                if ( targetPos_4 == null||selectPieces.isCatch(targetPos_4) ) {
                    pos[count][0] = GameFrame.black_select_y_conf - 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                }
            }
            else if(GameFrame.black_select_y_conf==5&&GameFrame.black_select_x_conf==4){
                Pieces targetPos_1 = piece_Board[GameFrame.black_select_y_conf + 1][GameFrame.black_select_x_conf];
                if ( targetPos_1 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf + 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_2 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1];
                if ( targetPos_2 == null||selectPieces.isCatch(targetPos_2) ) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf + 1;
                    count++;
                }
                Pieces targetPos_3 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1];
                if ( targetPos_3 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf - 1;
                    count++;
                }
                Pieces targetPos_4 = piece_Board[GameFrame.black_select_y_conf - 1][GameFrame.black_select_x_conf];
                if ( targetPos_4 == null||selectPieces.isCatch(targetPos_4) ) {
                    pos[count][0] = GameFrame.black_select_y_conf - 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                }
            }
            else if(GameFrame.black_select_y_conf==5&&GameFrame.black_select_x_conf==5){
                Pieces targetPos_1 = piece_Board[GameFrame.black_select_y_conf + 1][GameFrame.black_select_x_conf];
                if ( targetPos_1 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf + 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_2 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1];
                if ( targetPos_2 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf + 1;
                    count++;
                }
                Pieces targetPos_3 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1];
                if ( targetPos_3 == null||selectPieces.isCatch(targetPos_3) ) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf - 1;
                    count++;
                }
                Pieces targetPos_4 = piece_Board[GameFrame.black_select_y_conf - 1][GameFrame.black_select_x_conf];
                if ( targetPos_4 == null||selectPieces.isCatch(targetPos_4)) {
                    pos[count][0] = GameFrame.black_select_y_conf - 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                }
            }
            else {//老鼠不在河里
                int[][] dir= new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                for (int i = 0; i < 4; i++) {if(GameFrame.black_select_y_conf + dir[i][0] >= 0 && GameFrame.black_select_y_conf + dir[i][0] <= 8 &&
                        GameFrame.black_select_x_conf + dir[i][1] >= 0 && GameFrame.black_select_x_conf + dir[i][1] <= 6) {
                    Pieces target = piece_Board[GameFrame.black_select_y_conf+dir[i][0]][GameFrame.black_select_x_conf+dir[i][1]];
                    if (target == null || selectPieces.isCatch(target)) {
                            pos[count][0] = GameFrame.black_select_y_conf + dir[i][0];
                            pos[count][1] = GameFrame.black_select_x_conf + dir[i][1];
                            count++;
                        }
                    }
                }
            }
        }
        if(selectPieces.getRank()==0){//有问题
            //只有兽穴的位置，它可以去，还有没有棋子的地方，4种情况
            if(GameFrame.black_select_y_conf==0&&GameFrame.black_select_x_conf==2){
                Pieces targetPos_1 = piece_Board[GameFrame.black_select_y_conf + 1][GameFrame.black_select_x_conf];
                if ( targetPos_1 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf + 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_2 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1];
                if ( targetPos_2 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf + 1;
                    count++;
                }
                Pieces targetPos_3 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1];
                if ( targetPos_3 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf - 1;
                    count++;
                }
            }
            if(GameFrame.black_select_y_conf==0&&GameFrame.black_select_x_conf==4) {
                Pieces targetPos_1 = piece_Board[GameFrame.black_select_y_conf + 1][GameFrame.black_select_x_conf];
                if ( targetPos_1 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf + 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_2 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1];
                if ( targetPos_2 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf + 1;
                    count++;
                }
                Pieces targetPos_3 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1];
                if ( targetPos_3 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf - 1;
                    count++;
                }
            }
            if(GameFrame.black_select_y_conf==1&&GameFrame.black_select_x_conf==3){
                Pieces targetPos_1 = piece_Board[GameFrame.black_select_y_conf + 1][GameFrame.black_select_x_conf];
                if ( targetPos_1 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf + 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_2 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1];
                if ( targetPos_2 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf + 1;
                    count++;
                }
                Pieces targetPos_3 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1];
                if ( targetPos_3 == null||selectPieces.isCatch(targetPos_3) ) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf - 1;
                    count++;
                }
                Pieces targetPos_4 = piece_Board[GameFrame.black_select_y_conf-1][GameFrame.black_select_x_conf ];
                if ( targetPos_4 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf-1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
            }
            if(GameFrame.black_select_y_conf==8&&GameFrame.black_select_x_conf==2){
                Pieces targetPos_1 = piece_Board[GameFrame.black_select_y_conf - 1][GameFrame.black_select_x_conf];
                if ( targetPos_1 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf - 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_2 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1];
                if ( targetPos_2 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf + 1;
                    count++;
                }
                Pieces targetPos_3 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1];
                if ( targetPos_3 == null||selectPieces.isCatch(targetPos_3)) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf - 1;
                    count++;
                }
            }
            if(GameFrame.black_select_y_conf==8&&GameFrame.black_select_x_conf==4){
                Pieces targetPos_1 = piece_Board[GameFrame.black_select_y_conf - 1][GameFrame.black_select_x_conf];
                if ( targetPos_1 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf - 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_2 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1];
                if ( targetPos_2 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf + 1;
                    count++;
                }
                Pieces targetPos_3 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1];
                if ( targetPos_3 == null||selectPieces.isCatch(targetPos_3) ) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf - 1;
                    count++;
                }
            }
            if(GameFrame.black_select_y_conf==7&&GameFrame.black_select_x_conf==3){
                Pieces targetPos_1 = piece_Board[GameFrame.black_select_y_conf + 1][GameFrame.black_select_x_conf];
                if ( targetPos_1 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf + 1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
                Pieces targetPos_2 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf + 1];
                if ( targetPos_2 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf + 1;
                    count++;
                }
                Pieces targetPos_3 = piece_Board[GameFrame.black_select_y_conf][GameFrame.black_select_x_conf - 1];
                if ( targetPos_3 == null||selectPieces.isCatch(targetPos_3) ) {
                    pos[count][0] = GameFrame.black_select_y_conf;
                    pos[count][1] = GameFrame.black_select_x_conf - 1;
                    count++;
                }
                Pieces targetPos_4 = piece_Board[GameFrame.black_select_y_conf-1][GameFrame.black_select_x_conf ];
                if ( targetPos_4 == null) {
                    pos[count][0] = GameFrame.black_select_y_conf-1;
                    pos[count][1] = GameFrame.black_select_x_conf;
                    count++;
                }
            }
        }
    }
    public static int[][] getPosition(){
        return pos;
    }
}