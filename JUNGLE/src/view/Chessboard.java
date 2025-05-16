package view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import model.*;
public class Chessboard extends JPanel {
    @Override
    public void paint(Graphics graphics){
        Image[] newBufferImage = GameFrame.getChessBackground();
        graphics.drawImage(newBufferImage[GameFrame.select_chessBoard],0,0,null );
        if(GameFrame.black_select_x>=0&&GameFrame.black_select_y>=0&&GameFrame.black_select_y<=8&&GameFrame.black_select_x<=6){
            graphics.drawImage(GameFrame.black_select,GameFrame.black_select_x* GameFrame.PIECES_LENGTH_X+GameFrame.X_OFFSET,GameFrame.black_select_y*GameFrame.PIECES_LENGTH_Y+GameFrame.Y_OFFSET,null);
        }
        if(GameFrame.black_select_x_conf>=0&&GameFrame.black_select_y_conf>=0&&GameFrame.black_select_y_conf<=8&&GameFrame.black_select_x_conf<=6){
            //todo:需要判断在该位置上是否有棋子
            graphics.drawImage(GameFrame.black_select,GameFrame.black_select_x_conf* GameFrame.PIECES_LENGTH_X+GameFrame.X_OFFSET,GameFrame.black_select_y_conf*GameFrame.PIECES_LENGTH_Y+GameFrame.Y_OFFSET,null);
        }
        for (int i = 0; i < 4; i++) {

            if(pieceBoard.getPosition()[i][0]<=8&&pieceBoard.getPosition()[i][0]>=0&&pieceBoard.getPosition()[i][1]<=6&&pieceBoard.getPosition()[i][1]>=0){
            graphics.drawImage(GameFrame.green_select,pieceBoard.getPosition()[i][1]*GameFrame.PIECES_LENGTH_X+GameFrame.X_OFFSET,pieceBoard.getPosition()[i][0]*GameFrame.PIECES_LENGTH_Y+GameFrame.Y_OFFSET,null);}
        }
        for (int i = 0; i < GameFrame.BOARD_SIZE_ROW; i++) {
            for (int j = 0; j < GameFrame.BOARD_SIZE_COLUMN; j++) {
                if(charBoard.charBoard[i][j]=='0'){continue;}
                if(charBoard.charBoard[i][j]=='R'){graphics.drawImage(GameFrame.ratRed,GameFrame.X_OFFSET+GameFrame.PIECES_LENGTH_X*j,GameFrame.Y_OFFSET+GameFrame.PIECES_LENGTH_Y*i,null);}
                if(charBoard.charBoard[i][j]=='r'){graphics.drawImage(GameFrame.ratBlue,GameFrame.X_OFFSET+GameFrame.PIECES_LENGTH_X*j,GameFrame.Y_OFFSET+GameFrame.PIECES_LENGTH_Y*i,null);}
                if(charBoard.charBoard[i][j]=='C'){graphics.drawImage(GameFrame.catRed,GameFrame.X_OFFSET+GameFrame.PIECES_LENGTH_X*j,GameFrame.Y_OFFSET+GameFrame.PIECES_LENGTH_Y*i,null);}
                if(charBoard.charBoard[i][j]=='c'){graphics.drawImage(GameFrame.catBlue,GameFrame.X_OFFSET+GameFrame.PIECES_LENGTH_X*j,GameFrame.Y_OFFSET+GameFrame.PIECES_LENGTH_Y*i,null);}
                if(charBoard.charBoard[i][j]=='D'){graphics.drawImage(GameFrame.dogRed,GameFrame.X_OFFSET+GameFrame.PIECES_LENGTH_X*j,GameFrame.Y_OFFSET+GameFrame.PIECES_LENGTH_Y*i,null);}
                if(charBoard.charBoard[i][j]=='d'){graphics.drawImage(GameFrame.dogBlue,GameFrame.X_OFFSET+GameFrame.PIECES_LENGTH_X*j,GameFrame.Y_OFFSET+GameFrame.PIECES_LENGTH_Y*i,null);}
                if(charBoard.charBoard[i][j]=='W'){graphics.drawImage(GameFrame.wolfRed,GameFrame.X_OFFSET+GameFrame.PIECES_LENGTH_X*j,GameFrame.Y_OFFSET+GameFrame.PIECES_LENGTH_Y*i,null);}
                if(charBoard.charBoard[i][j]=='w'){graphics.drawImage(GameFrame.wolfBlue,GameFrame.X_OFFSET+GameFrame.PIECES_LENGTH_X*j,GameFrame.Y_OFFSET+GameFrame.PIECES_LENGTH_Y*i,null);}
                if(charBoard.charBoard[i][j]=='L'){graphics.drawImage(GameFrame.leopardRed,GameFrame.X_OFFSET+GameFrame.PIECES_LENGTH_X*j,GameFrame.Y_OFFSET+GameFrame.PIECES_LENGTH_Y*i,null);}
                if(charBoard.charBoard[i][j]=='l'){graphics.drawImage(GameFrame.leopardBlue,GameFrame.X_OFFSET+GameFrame.PIECES_LENGTH_X*j,GameFrame.Y_OFFSET+GameFrame.PIECES_LENGTH_Y*i,null);}
                if(charBoard.charBoard[i][j]=='T'){graphics.drawImage(GameFrame.tigerRed,GameFrame.X_OFFSET+GameFrame.PIECES_LENGTH_X*j,GameFrame.Y_OFFSET+GameFrame.PIECES_LENGTH_Y*i,null);}
                if(charBoard.charBoard[i][j]=='t'){graphics.drawImage(GameFrame.tigerBlue,GameFrame.X_OFFSET+GameFrame.PIECES_LENGTH_X*j,GameFrame.Y_OFFSET+GameFrame.PIECES_LENGTH_Y*i,null);}
                if(charBoard.charBoard[i][j]=='I'){graphics.drawImage(GameFrame.lionRed,GameFrame.X_OFFSET+GameFrame.PIECES_LENGTH_X*j,GameFrame.Y_OFFSET+GameFrame.PIECES_LENGTH_Y*i,null);}
                if(charBoard.charBoard[i][j]=='i'){graphics.drawImage(GameFrame.lionBlue,GameFrame.X_OFFSET+GameFrame.PIECES_LENGTH_X*j,GameFrame.Y_OFFSET+GameFrame.PIECES_LENGTH_Y*i,null);}
                if(charBoard.charBoard[i][j]=='E'){graphics.drawImage(GameFrame.elephantRed,GameFrame.X_OFFSET+GameFrame.PIECES_LENGTH_X*j,GameFrame.Y_OFFSET+GameFrame.PIECES_LENGTH_Y*i,null);}
                if(charBoard.charBoard[i][j]=='e'){graphics.drawImage(GameFrame.elephantBlue,GameFrame.X_OFFSET+GameFrame.PIECES_LENGTH_X*j,GameFrame.Y_OFFSET+GameFrame.PIECES_LENGTH_Y*i,null);}
            }
        }
        graphics.dispose();
    }
}
