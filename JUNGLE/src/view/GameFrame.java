package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import connectNet.client;
import connectNet.server;
import model.*;
import music.*;

public class GameFrame extends Thread {

    public static initPVPGameFrame playPVPGameFrame;
    public static boolean isPlayPVP = false;

    public void startPVP() {
        synchronized (this) {
            playPVPGameFrame = new initPVPGameFrame();
            playPVPGameFrame.start();
            isPlayPVP = true;
        }
    }

    public static initEasyAIGameFrame playEasyAIGameFrame;
    public static boolean isPlayEasyAi = false;

    public void startEasyAI() {
        synchronized (this) {
            playEasyAIGameFrame = new initEasyAIGameFrame();
            playEasyAIGameFrame.start();
            isPlayEasyAi = true;
        }
    }

    public static initHardAIGameFrame playHardAIGameFrame;
    public static boolean isPlayHardAi = false;

    public void startHardAI() {
        synchronized (this) {
            playHardAIGameFrame = new initHardAIGameFrame();
            playHardAIGameFrame.start();
            isPlayHardAi = true;
        }
    }

    public JFrame gameFrame = new JFrame("PROJECT_2023_CS109SPRING_JUNGLE");
    JPanel current = new JPanel();
    String string;
    JLabel time = new JLabel();
    JButton reStart = new JButton("                Restart               ");
    JButton retract = new JButton("                Retract               ");
    JButton playBack = new JButton("              Playback              ");
    JButton setting = new JButton("                 Setting              ");
    JButton returnToMainFrame = new JButton("   Return to Main Frame   ");
    Box jp = Box.createVerticalBox();
    JButton Save = new JButton("                  Save                 ");
    JButton Load = new JButton("                  Load                 ");
    JButton chat = new JButton("                  Chat                 ");

    public static Chessboard chessboard = new Chessboard();
    private static Playback playback;
    public static Image[] chessBackground = new Image[5];

    public static int select_chessBoard = 0;
    public static boolean easyAi = false;
    Image chessBoard_1;

    {
        try {
            chessBoard_1 = ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src/image/chessboard/chessboard(1)(1)(1).jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (chessBoard_1 != null) {
                chessBoard_1.flush();
                chessBoard_1.getGraphics().dispose();
            }
        }
    }

    Image chessBoard_2;

    {
        try {
            chessBoard_2 = ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src/image/chessboard/chessboard(2)(1).jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (chessBoard_2 != null) {
                chessBoard_2.flush();
                chessBoard_2.getGraphics().dispose();
            }
        }
    }

    Image chessBoard_3;

    {
        try {
            chessBoard_3 = ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src/image/chessboard/chessboard(3)(1)(1).jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (chessBoard_3 != null) {
                chessBoard_3.flush();
                chessBoard_3.getGraphics().dispose();

            }
        }
    }

    Image chessBoard_4;

    {
        try {
            chessBoard_4 = ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src/image/chessboard/chessboard(4)(1)(1).jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (chessBoard_4 != null) {
                chessBoard_4.flush();
                chessBoard_4.getGraphics().dispose();

            }
        }
    }

    Image chessBoard_5;

    {
        try {
            chessBoard_5 = ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src/image/chessboard/chessboard(5)(1)(1).jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (chessBoard_5 != null) {
                chessBoard_5.flush();
                chessBoard_5.getGraphics().dispose();

            }
        }
    }

    public static Image ratRed;

    {
        try {
            ratRed = ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src/image/piecesRed/红圈(1).png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (ratRed != null) {
                ratRed.getGraphics().dispose();
            }
        }
    }

    public static Image ratBlue;

    {
        try {
            ratBlue = ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src/image/piecesBlue/蓝圈(1).png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (ratBlue != null) {
                ratBlue.getGraphics().dispose();
            }
        }
    }

    public static Image catRed;

    {
        try {
            catRed = ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src/image/piecesRed/红圈(2).png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (catRed != null) {
                catRed.getGraphics().dispose();
            }
        }
    }

    public static Image catBlue;

    {
        try {
            catBlue = ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src/image/piecesBlue/蓝圈(2).png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (catBlue != null) {
                catBlue.getGraphics().dispose();
            }
        }
    }

    public static Image dogRed;

    {
        try {
            dogRed = ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src/image/piecesRed/红圈(3).png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (dogRed != null) {
                dogRed.getGraphics().dispose();
            }
        }
    }

    public static Image dogBlue;

    {
        try {
            dogBlue = ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src/image/piecesBlue/蓝圈(3).png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (dogBlue != null) {
                dogBlue.getGraphics().dispose();
            }
        }
    }

    public static Image wolfBlue;

    {
        try {
            wolfBlue = ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src/image/piecesBlue/蓝圈(4).png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (wolfBlue != null) {
                wolfBlue.getGraphics().dispose();
            }
        }
    }

    public static Image wolfRed;

    {
        try {
            wolfRed = ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src/image/piecesRed/红圈(4).png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (wolfRed != null) {
                wolfRed.getGraphics().dispose();
            }
        }
    }

    public static Image leopardRed;

    {
        try {
            leopardRed = ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src/image/piecesRed/红圈(5).png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (leopardRed != null) {
                leopardRed.getGraphics().dispose();
            }
        }
    }

    public static Image leopardBlue;

    {
        try {
            leopardBlue = ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src/image/piecesBlue/蓝圈(5).png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (leopardBlue != null) {
                leopardBlue.getGraphics().dispose();
            }
        }
    }

    public static Image tigerRed;

    {
        try {
            tigerRed = ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src/image/piecesRed/红圈(6).png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (tigerRed != null) {
                tigerRed.getGraphics().dispose();
            }
        }
    }

    public static Image tigerBlue;

    {
        try {
            tigerBlue = ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src/image/piecesBlue/蓝圈(6).png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (tigerBlue != null) {
                tigerBlue.getGraphics().dispose();
            }
        }
    }

    public static Image lionBlue;

    {
        try {
            lionBlue = ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src/image/piecesBlue/蓝圈(7).png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (lionBlue != null) {
                lionBlue.getGraphics().dispose();
            }
        }
    }

    public static Image lionRed;

    {
        try {
            lionRed = ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src/image/piecesRed/红圈(7).png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (lionRed != null) {
                lionRed.getGraphics().dispose();
            }
        }
    }

    public static Image elephantRed;

    {
        try {
            elephantRed = ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src/image/piecesRed/红圈(8).png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (elephantRed != null) {
                elephantRed.getGraphics().dispose();
            }
        }
    }

    public static Image elephantBlue;

    {
        try {
            elephantBlue = ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src/image/piecesBlue/蓝圈(8).png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (elephantBlue != null) {
                elephantBlue.getGraphics().dispose();
            }
        }
    }

    final int WIDTH = 1269;
    final int HEIGHT = 909;

    public static final int BOARD_SIZE_ROW = 9;
    public static final int BOARD_SIZE_COLUMN = 7;

    public static final int PIECES_LENGTH_X = 103;
    public static final int PIECES_LENGTH_Y = 99;


    public static final int X_OFFSET = 271;
    public static final int Y_OFFSET = 1;
    int count = 0;
    public static BufferedImage black_select;

    {
        try {
            black_select = ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src/image/chessboard/黑色选择框.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (black_select != null) {
                black_select.getGraphics().dispose();
            }
        }
    }

    public static BufferedImage green_select;

    {
        try {
            green_select = ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src/image/chessboard/可能棋子位置.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (green_select != null) {
                green_select.getGraphics().dispose();
            }
        }
    }

    public static int black_select_x = -2;
    public static int black_select_x_conf = -1;//第一次选择框的位置
    public static int black_select_x_conf_2 = -1;//第二次选择框的位置
    public static int black_select_y = -2;
    public static int black_select_y_conf = -2;
    public static int black_select_y_conf_2 = -2;

    public static int num = 1;

    public boolean click = false;
    public Timer timer;
    public TimeCount timeCount;
    public static boolean isPlayTimer = false;

    public GameFrame() {
        this.setChessBackground();
        gameFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                initBoard();
            }

        });
    }

    public class Playback extends Thread {
        @Override
        public void run() {
            synchronized (this) {
                int num = charBoard.Rounds;
                for (int i = 0; i < num; i++) {
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
                    int first = 68 * i + 1;
                    for (int k = 0; k < 9; k++) {
                        for (int j = 0; j < 7; j++) {
                            charBoard.charBoard[k][j] = targetStr.charAt(first);
                            first++;
                            System.out.print(charBoard.charBoard[k][j]);
                        }
                        System.out.println();
                    }
                    try {
                        fileReader.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    chessboard.repaint();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public class TimeCount extends Thread {
        @Override
        public void run() {
            if (isPlayTimer) {
                for (int i = 30; i >= 0; i--) {
                    if (i != 0) {
                        if (charBoard.getCurrentPlayer() == 2) {
                            string = "Turn " + charBoard.Rounds + ":Blue Time:" + i;
                            time.setText(string);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            string = "Turn " + charBoard.Rounds + ":Red  Time:" + i;
                            time.setText(string);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    } else {
                        charBoard.readChessBoard();
                        pieceBoard.readBoard();
                        black_select_x_conf = 0;
                        black_select_y_conf = 0;
                        black_select_x_conf_2 = 0;
                        black_select_y_conf_2 = 0;

                        pieceBoard.setPos_Default();
                        pieceBoard.writeBoard();
                        try {
                            charBoard.writeChessboard();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        black_select_x_conf = -1;
                        black_select_y_conf = -1;
                        black_select_x_conf_2 = -1;
                        black_select_y_conf_2 = -1;
                        num = 1;
                        charBoard.setNextCurrentPlayer();
                        i = 31;
                    }
                }
            }
        }
    }


    public void initBoard() {
        charBoard.charBoard = new char[][]{
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
        pieceBoard.deleteBoard();
        charBoard.setCharBoard_restart();
        pieceBoard.pos = new int[][]{{-4, -4}, {-4, -4}, {-4, -4}, {-4, -4}};
        pieceBoard.count = 0;
        pieceBoard.y_1 = 0;
        pieceBoard.x_1 = 0;
        pieceBoard.y_2 = 0;
        pieceBoard.x_2 = 0;
        File addUser = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//Files//chessboard");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(addUser);
        } catch (IOException m) {
            throw new RuntimeException(m);
        }
        try {
            fileWriter.write(0 + "\n");
        } catch (IOException m) {
            throw new RuntimeException(m);
        }
        try {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 7; j++) {
                    fileWriter.write(charBoard.charBoard[i][j] + "");
                }
                fileWriter.write("\n");
            }

        } catch (IOException m) {
            throw new RuntimeException(m);
        }
        try {
            fileWriter.write("0000" + "\n");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        try {
            fileWriter.close();
        } catch (IOException m) {
            throw new RuntimeException(m);
        }
        charBoard.setNextCurrentPlayer();
        black_select_x_conf = -1;
        black_select_y_conf = -1;
        black_select_x_conf_2 = -1;
        black_select_y_conf_2 = -1;
        num = 1;
        chessboard.repaint();
        click = false;
    }
    public void initBoardC() {
        charBoard.charBoard = new char[][]{
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
        pieceBoard.deleteBoard();
        charBoard.setCharBoard_restart();
        pieceBoard.pos = new int[][]{{-4, -4}, {-4, -4}, {-4, -4}, {-4, -4}};
        pieceBoard.count = 0;
        pieceBoard.y_1 = 0;
        pieceBoard.x_1 = 0;
        pieceBoard.y_2 = 0;
        pieceBoard.x_2 = 0;
        File addUser = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//Files//chessboard(client)");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(addUser);
        } catch (IOException m) {
            throw new RuntimeException(m);
        }
        try {
            fileWriter.write(0 + "\n");
        } catch (IOException m) {
            throw new RuntimeException(m);
        }
        try {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 7; j++) {
                    fileWriter.write(charBoard.charBoard[i][j] + "");
                }
                fileWriter.write("\n");
            }

        } catch (IOException m) {
            throw new RuntimeException(m);
        }
        try {
            fileWriter.write("0000" + "\n");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        try {
            fileWriter.close();
        } catch (IOException m) {
            throw new RuntimeException(m);
        }
        charBoard.setNextCurrentPlayer();
        black_select_x_conf = -1;
        black_select_y_conf = -1;
        black_select_x_conf_2 = -1;
        black_select_y_conf_2 = -1;
        num = 1;
        chessboard.repaint();
        click = false;
    }
    public void initBoardS() {
        charBoard.charBoard = new char[][]{
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
        pieceBoard.deleteBoard();
        charBoard.setCharBoard_restart();
        pieceBoard.pos = new int[][]{{-4, -4}, {-4, -4}, {-4, -4}, {-4, -4}};
        pieceBoard.count = 0;
        pieceBoard.y_1 = 0;
        pieceBoard.x_1 = 0;
        pieceBoard.y_2 = 0;
        pieceBoard.x_2 = 0;
        File addUser = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//Files//chessboard(server)");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(addUser);
        } catch (IOException m) {
            throw new RuntimeException(m);
        }
        try {
            fileWriter.write(0 + "\n");
        } catch (IOException m) {
            throw new RuntimeException(m);
        }
        try {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 7; j++) {
                    fileWriter.write(charBoard.charBoard[i][j] + "");
                }
                fileWriter.write("\n");
            }

        } catch (IOException m) {
            throw new RuntimeException(m);
        }
        try {
            fileWriter.write("0000" + "\n");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        try {
            fileWriter.close();
        } catch (IOException m) {
            throw new RuntimeException(m);
        }
        charBoard.setNextCurrentPlayer();
        black_select_x_conf = -1;
        black_select_y_conf = -1;
        black_select_x_conf_2 = -1;
        black_select_y_conf_2 = -1;
        num = 1;
        chessboard.repaint();
        click = false;
    }



    int second = 30;

    public void initGameFrame() {
        if (playPVPGameFrame != null) System.out.println(playPVPGameFrame.isAlive() + "PVP");
        if (playEasyAIGameFrame != null) System.out.println(playEasyAIGameFrame.isAlive() + "AiEasy");
        initBoard();
        current.add(time, BorderLayout.CENTER);
        time.setSize(300, 300);
        time.setFont(new Font("宋体", Font.PLAIN, 30));
        time.setOpaque(true);
        time.setForeground(Color.BLUE);
        gameFrame.setBounds(10, 5, WIDTH + 150, HEIGHT + 75);
        reStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO:重新设置初始界面；
                initBoard();
                if (timeCount != null) timeCount.stop();
                timeCount = new TimeCount();
                timeCount.start();
            }
        });
        retract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo:调出上一步存储的文件，重新加载界面；
                if (charBoard.Rounds == 1) {
                } else {
                    charBoard.readLastBoard();
                    charBoard.setLastPar();
                    pieceBoard.pos = new int[][]{{-4, -4}, {-4, -4}, {-4, -4}, {-4, -4}};
                    pieceBoard.count = 0;
                    pieceBoard.y_1 = 0;
                    pieceBoard.x_1 = 0;
                    pieceBoard.y_2 = 0;
                    pieceBoard.x_2 = 0;
                    black_select_x_conf = -1;
                    black_select_y_conf = -1;
                    black_select_x_conf_2 = -1;
                    black_select_y_conf_2 = -1;
                    num = 1;
                    pieceBoard.deleteBoard();
                    charBoard.readChessBoard();
                    pieceBoard.readBoard();
                    chessboard.repaint();
                    timeCount.stop();
                    timeCount = new TimeCount();
                    timeCount.start();
                }
            }
        });
        playBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playback = new Playback();
                playback.start();
            }
        });
        Load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//todo:加载文件
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.showOpenDialog(gameFrame);
                File file = jFileChooser.getSelectedFile();
                String fileName = file.getName();
                if (!fileName.substring(fileName.lastIndexOf(".")).equals(".txt")) {//后缀名错误
                    JOptionPane.showMessageDialog(gameFrame, "101", "Wrong load", JOptionPane.WARNING_MESSAGE);
                } else {
                    BufferedReader reader;
                    try {
                        reader = new BufferedReader(new FileReader(file));
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    List<String> line = new ArrayList<>();
                    try {
                        line.add(reader.readLine());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println(line + "load");
                    int num_1 = 0;
                    boolean correct = true;
                    num_1++;
                    try {
                        line.add(reader.readLine());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    while (line.get(num_1) != null) {
                        if (num_1 % 11 == 1 && line.get(num_1) != null) {
                            for (int i = 1; i <= 9; i++) {
                                if (line.get(i).length() != 7) {
                                    JOptionPane.showMessageDialog(gameFrame, "102", "Wrong load", JOptionPane.WARNING_MESSAGE);//棋盘错误
                                    correct = false;
                                    break;
                                }
                                try {
                                    line.add(reader.readLine());
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                                num_1++;
                                int[][] countPieces = new int[8][2];
                                if (i == 9) {
                                    for (int j = 1; j <= 9; j++) {
                                        for (int k = 0; k < 7; k++) {
                                            if (line.get(j).charAt(k) == 'R') {
                                                countPieces[0][0]++;
                                            }
                                            if (line.get(j).charAt(k) == 'r') {
                                                countPieces[0][1]++;
                                            }
                                            if (line.get(j).charAt(k) == 'C') {
                                                countPieces[1][0]++;
                                            }
                                            if (line.get(j).charAt(k) == 'c') {
                                                countPieces[1][1]++;
                                            }
                                            if (line.get(j).charAt(k) == 'D') {
                                                countPieces[2][0]++;
                                            }
                                            if (line.get(j).charAt(k) == 'd') {
                                                countPieces[2][1]++;
                                            }
                                            if (line.get(j).charAt(k) == 'W') {
                                                countPieces[3][0]++;
                                            }
                                            if (line.get(j).charAt(k) == 'w') {
                                                countPieces[3][1]++;
                                            }
                                            if (line.get(j).charAt(k) == 'L') {
                                                countPieces[4][0]++;
                                            }
                                            if (line.get(j).charAt(k) == 'l') {
                                                countPieces[4][1]++;
                                            }
                                            if (line.get(j).charAt(k) == 'T') {
                                                countPieces[5][0]++;
                                            }
                                            if (line.get(j).charAt(k) == 't') {
                                                countPieces[5][1]++;
                                            }
                                            if (line.get(j).charAt(k) == 'I') {
                                                countPieces[6][0]++;
                                            }
                                            if (line.get(j).charAt(k) == 'i') {
                                                countPieces[6][1]++;
                                            }
                                            if (line.get(j).charAt(k) == 'E') {
                                                countPieces[7][0]++;
                                            }
                                            if (line.get(j).charAt(k) == 'e') {
                                                countPieces[7][1]++;
                                            }
                                        }
                                    }
                                    for (int j = 0; j <= 7; j++) {
                                        for (int k = 0; k < 2; k++) {
                                            if (countPieces[j][k] > 1) {
                                                JOptionPane.showMessageDialog(gameFrame, "103", "Wrong load", JOptionPane.WARNING_MESSAGE);//棋子数目错误
                                                correct = false;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            System.out.println(num_1);
                            System.out.println(line.get(num_1));
                        }

                        if (num_1 % 11 == 10 && line.get(num_1) == null) {
                            JOptionPane.showMessageDialog(gameFrame, "104", "Wrong load", JOptionPane.WARNING_MESSAGE);//没有行棋方错误
                            correct = false;
                            break;
                        }
                        System.out.println(line.size());
                        num_1++;
                        try {
                            line.add(reader.readLine());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        System.out.println(line.get(num_1));
                    }
                    System.out.println(correct);
                    if (correct) {
                        File file1 = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//Files//chessboard");
                        BufferedWriter bufferedWriter;
                        try {
                            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file1)));
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                        for (int i = 0; i < line.size() - 1; i++) {
                            try {
                                bufferedWriter.write(line.get(i).toString() + "\n");
                                System.out.println(line.get(i));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                        try {
                            bufferedWriter.close();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        charBoard.Rounds = (line.size()) / 11 - 1;
                        System.out.println(charBoard.Rounds);
                        charBoard.setNextCurrentPlayer();
                        charBoard.readChessBoard();
                        pieceBoard.pos = new int[][]{{-4, -4}, {-4, -4}, {-4, -4}, {-4, -4}};
                        pieceBoard.count = 0;
                        pieceBoard.y_1 = 0;
                        pieceBoard.x_1 = 0;
                        pieceBoard.y_2 = 0;
                        pieceBoard.x_2 = 0;
                        black_select_x_conf = -1;
                        black_select_y_conf = -1;
                        black_select_x_conf_2 = -1;
                        black_select_y_conf_2 = -1;
                        num = 1;
                        pieceBoard.deleteBoard();
                        charBoard.readChessBoard();
                        pieceBoard.readBoard();
                        chessboard.repaint();
                        timeCount.stop();
                        timeCount = new TimeCount();
                        timeCount.start();
                    }
                }

            }
        });
        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "文件类型(*.txt)", "txt");
                jFileChooser.setFileFilter(filter);
                int option = jFileChooser.showSaveDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {    //假如用户选择了保存
                    File jFileChooserSelectedFile = jFileChooser.getSelectedFile();
                    String fname = jFileChooser.getName(jFileChooserSelectedFile);    //从文件名输入框中获取文件名
                    // 添上后缀
                    if (fname.indexOf(".txt") == -1) {
                        jFileChooserSelectedFile = new File(jFileChooser.getCurrentDirectory(), fname + ".txt");
                    }
                    File file = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//Files//chessboard");
                    StringBuffer stringBuffer = new StringBuffer();
                    FileInputStream fileInputStream = null;
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    BufferedWriter bufferedWriter;
                    try {
                        bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(jFileChooserSelectedFile)));
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String str;
                    while (true) {
                        try {
                            if (!((str = bufferedReader.readLine()) != null)) break;
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {
                            bufferedWriter.write(str + "\n");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        stringBuffer.append(str);
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        inputStreamReader.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    try {
                        bufferedWriter.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            }
        });
        setting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SettingFrame().initSettingFrame();
            }
        });
        returnToMainFrame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    new MainFrame().initMainFrame();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } finally {
                    if (playPVPGameFrame != null) {
                        playPVPGameFrame.stop();
                        System.out.println(playPVPGameFrame.isAlive());
                        gameFrame.dispose();
                    }
                    if (playEasyAIGameFrame != null) {
                        playEasyAIGameFrame.stop();
                        gameFrame.dispose();
                    }
                    if (playHardAIGameFrame != null) {
                        playHardAIGameFrame.stop();
                        gameFrame.dispose();
                    }
                    isPlayPVP = false;
                    isPlayEasyAi = false;
                    isPlayHardAi = false;
                }
                if (timeCount != null) timeCount.stop();
            }
        });
        jp.add(Box.createVerticalStrut(200));
        jp.add(reStart);
        jp.add(Box.createVerticalStrut(50));
        jp.add(retract);
        jp.add(Box.createVerticalStrut(50));
        jp.add(playBack);
        jp.add(Box.createVerticalStrut(50));
        jp.add(setting);
        jp.add(Box.createVerticalStrut(50));
        jp.add(returnToMainFrame);
        jp.add(Box.createVerticalStrut(50));
        jp.add(Load);
        jp.add(Box.createVerticalStrut(50));
        jp.add(Save);
        jp.add(Box.createVerticalStrut(50));
        jp.add(chat);
        gameFrame.add(current, BorderLayout.SOUTH);
        gameFrame.add(jp, BorderLayout.EAST);
        if (!easyAi) {
            timeCount = new TimeCount();
            timeCount.start();
        }
        chessboard.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                black_select_x = (e.getX() - X_OFFSET) / PIECES_LENGTH_X;
                black_select_y = (e.getY() - Y_OFFSET) / PIECES_LENGTH_Y;
                chessboard.repaint();

            }
        });


        chessboard.setBounds(0, 0, WIDTH, HEIGHT);
        gameFrame.add(chessboard);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
    }

    public static Image[] getChessBackground() {
        return chessBackground;
    }

    public void setChessBackground() {
        chessBackground[0] = chessBoard_1;
        chessBackground[1] = chessBoard_2;
        chessBackground[2] = chessBoard_3;
        chessBackground[3] = chessBoard_4;
        chessBackground[4] = chessBoard_5;
    }

    public class initPVPGameFrame extends Thread {
        @Override
        public void run() {
            super.run();
            initGameFrame();
            System.out.println("yunxingPVP");
            chessboard.addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    click = true;
                    if (click && isPlayPVP) {
                        super.mousePressed(e);
                        charBoard.readChessBoard();
                        pieceBoard.readBoard();
                        System.out.println(num);
                        if (num == 1) {
                            black_select_x_conf = (e.getX() - X_OFFSET) / PIECES_LENGTH_X;
                            black_select_y_conf = (e.getY() - Y_OFFSET) / PIECES_LENGTH_Y;
                            System.out.println("yunxingPVP123");
                        }
                        if (charBoard.setFirstChoose() && num == 1) {
                            new clicked().startClick();
                            System.out.println("choose first right");
                            pieceBoard.getPos();
                            for (int i = 0; i < 4; i++) {
                                System.out.print(pieceBoard.pos[i][0] + " ");
                                System.out.println(pieceBoard.pos[i][1]);
                            }
                            chessboard.repaint();
                            num++;
                            System.out.println("yunxingPVP123456");
                        } else if (num == 2) {
                            System.out.println("yunxingPVP000");
                            black_select_x_conf_2 = (e.getX() - X_OFFSET) / PIECES_LENGTH_X;
                            black_select_y_conf_2 = (e.getY() - Y_OFFSET) / PIECES_LENGTH_Y;
                            if (charBoard.setSecondChoose()) {
                                System.out.println("yunxingPVP111");
                                new clicked().startClick();
                                System.out.println("choose second right");
                                pieceBoard.changeBoard();
                                pieceBoard.setPos_Default();
                                chessboard.repaint();
                                if (pieceBoard.checkWin()) {
                                    if (charBoard.getCurrentPlayer() == 2) {//蓝方胜利
                                        if (easyAi) {
                                            manageUser.getUsers().get(LoginFrame.currentIndex).setWinNumber(manageUser.getUsers().get(LoginFrame.currentIndex).getWinNumber() + 1);
                                            System.out.println(manageUser.getUsers().get(LoginFrame.currentIndex).getWinNumber() + "胜局");
                                            manageUser.writeFile();
                                        }
                                        String message = "Blue Win";
                                        System.out.println(message);
                                        int confirm = JOptionPane.showConfirmDialog(gameFrame, message, "Result", JOptionPane.DEFAULT_OPTION);
                                        if (confirm == JOptionPane.OK_OPTION) {
                                            initBoard();
                                            if (timeCount != null) timeCount.stop();
                                            if (!easyAi) {
                                                timeCount = new TimeCount();
                                                timeCount.start();
                                            }
                                        }
                                    } else {//红方胜利
                                        String message = "Red Win";
                                        int confirm = JOptionPane.showConfirmDialog(gameFrame, message, "Result", JOptionPane.DEFAULT_OPTION);
                                        if (confirm == JOptionPane.OK_OPTION) {
                                            initBoard();
                                            if (timeCount != null) timeCount.stop();
                                            if (!easyAi) {
                                                timeCount = new TimeCount();
                                                timeCount.start();
                                            }
                                        }
                                    }
                                } else {
                                    pieceBoard.writeBoard();
                                    try {
                                        charBoard.writeChessboard();
                                    } catch (IOException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                    black_select_x_conf = -1;
                                    black_select_y_conf = -1;
                                    black_select_x_conf_2 = -1;
                                    black_select_y_conf_2 = -1;
                                    num = 1;
                                    charBoard.setNextCurrentPlayer();
                                    if (timeCount != null) timeCount.stop();
                                    timeCount = new TimeCount();
                                    timeCount.start();
                                    System.out.println("renshenjieguo");
                                }
                            }
                        }
                    }

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    super.mouseReleased(e);
                    click = false;
                }
            });
        }
    }
    private boolean s = false;
    public void s(){
        s = true;
    }
    public void initServer() throws IOException {
        chat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Chat.server.startS();
            }
        });

        initGameFrame();
        //建立新的服务端
        connectNet.server serverSocket = new server();
        //接收最新的棋盘信息
        serverSocket.receiveDateToSocket();
        //显示棋盘，不然总要鼠标先点一下才出来，我也不知道为什么
        charBoard.readChessBoardS();
        pieceBoard.readBoard();
        chessboard.repaint();
        //接收完信息，换人
        charBoard.setNextCurrentPlayer();
        chessboard.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                black_select_x = (e.getX() - X_OFFSET) / PIECES_LENGTH_X;
                black_select_y = (e.getY() - Y_OFFSET) / PIECES_LENGTH_Y;
                charBoard.readChessBoardS();
                pieceBoard.readBoard();
                if (pieceBoard.checkWin()) {
                    if (charBoard.getCurrentPlayer() == 2) {//蓝方胜利
                        if (easyAi) {
                            manageUser.getUsers().get(LoginFrame.currentIndex).setWinNumber(manageUser.getUsers().get(LoginFrame.currentIndex).getWinNumber() + 1);
                            System.out.println(manageUser.getUsers().get(LoginFrame.currentIndex).getWinNumber() + "胜局");
                            manageUser.writeFile();
                        }
                        String message = "Blue Win";
                        System.out.println(message);
                        int confirm = JOptionPane.showConfirmDialog(gameFrame, message, "Result", JOptionPane.DEFAULT_OPTION);
                        if (confirm == JOptionPane.OK_OPTION) {
                            initBoardS();
                            if (timeCount != null) timeCount.stop();
                            if (!easyAi) {
                                timeCount = new TimeCount();
                                timeCount.start();
                            }
                        }
                    } else {//红方胜利
                        String message = "Red Win";
                        int confirm = JOptionPane.showConfirmDialog(gameFrame, message, "Result", JOptionPane.DEFAULT_OPTION);
                        if (confirm == JOptionPane.OK_OPTION) {
                            initBoardS();
                            if (timeCount != null) timeCount.stop();
                            if (!easyAi) {
                                timeCount = new TimeCount();
                                timeCount.start();
                            }
                        }
                    }
                }
                chessboard.repaint();
            }
        });
        chessboard.addMouseListener(new MouseAdapter() {
            Boolean click = false;

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                charBoard.readChessBoardS();
                pieceBoard.readBoard();
                System.out.println(charBoard.charBoard+"写入的棋盘");
                System.out.println(num);
                if (num == 1) {
                    black_select_x_conf = (e.getX() - X_OFFSET) / PIECES_LENGTH_X;
                    black_select_y_conf = (e.getY() - Y_OFFSET) / PIECES_LENGTH_Y;
                }
                if (charBoard.setFirstChoose() && num == 1) {
                    new clicked().startClick();
                    System.out.println("choose first right");
                    pieceBoard.getPos();
                    for (int i = 0; i < 4; i++) {
                        System.out.print(pieceBoard.pos[i][0]+" ");
                        System.out.println(pieceBoard.pos[i][1]);
                    }
                    chessboard.repaint();
                    num++;
                }else if(num==2){
                    black_select_x_conf_2 = (e.getX() - X_OFFSET) / PIECES_LENGTH_X;
                    black_select_y_conf_2 = (e.getY() - Y_OFFSET) / PIECES_LENGTH_Y;
                    if (charBoard.setSecondChoose()) {
                        new clicked().startClick();
                        System.out.println("choose second right");
                        pieceBoard.changeBoard();
                        pieceBoard.setPos_Default();
                        chessboard.repaint();
                        pieceBoard.writeBoard();
                        try {
                            charBoard.writeChessboardS();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        black_select_x_conf = -1;
                        black_select_y_conf = -1;
                        black_select_x_conf_2 = -1;
                        black_select_y_conf_2 = -1;
                        num = 1;
                        //把判断用的参数改为true，保证点击有效时才传数据
                        s();
                        charBoard.setNextCurrentPlayer();
                    }
                }
                click = true;
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                click = false;
                if(s){
                    //发数据
                    try {
                        serverSocket.sendDataToSocket();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    if (pieceBoard.checkWin()) {
                        if (charBoard.getCurrentPlayer() == 2) {//蓝方胜利
                            if (easyAi) {
                                manageUser.getUsers().get(LoginFrame.currentIndex).setWinNumber(manageUser.getUsers().get(LoginFrame.currentIndex).getWinNumber() + 1);
                                System.out.println(manageUser.getUsers().get(LoginFrame.currentIndex).getWinNumber() + "胜局");
                                manageUser.writeFile();
                            }
                            String message = "Blue Win";
                            System.out.println(message);
                            int confirm = JOptionPane.showConfirmDialog(gameFrame, message, "Result", JOptionPane.DEFAULT_OPTION);
                            if (confirm == JOptionPane.OK_OPTION) {
                                initBoardS();
                                if (timeCount != null) timeCount.stop();
                                if (!easyAi) {
                                    timeCount = new TimeCount();
                                    timeCount.start();
                                }
                            }
                        } else {//红方胜利
                            String message = "Red Win";
                            int confirm = JOptionPane.showConfirmDialog(gameFrame, message, "Result", JOptionPane.DEFAULT_OPTION);
                            if (confirm == JOptionPane.OK_OPTION) {
                                initBoardS();
                                if (timeCount != null) timeCount.stop();
                                if (!easyAi) {
                                    timeCount = new TimeCount();
                                    timeCount.start();
                                }
                            }
                        }
                    }else {

                    //收数据，当数据没收到时棋盘会卡住
                    try {
                        serverSocket.receiveDateToSocket();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    //想要在收到数据后重绘棋盘，但是没成
                    charBoard.setNextCurrentPlayer();
                    s = false;}
                }
            }
        });

    }

    /**联网对战中客户端会打开的界面，默认其为蓝方
     */
    //用于判断的参数
    private boolean c = false;
    //别问为什么要写这个方法，问就是在override里没法永久改变子类参数的值，只能暂时改变
    public void c(){
        c = true;
    }
    public void initClient() throws IOException {
        chat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Chat.client.startC();
            }
        });
        initGameFrame();
        charBoard.readChessBoardC();
        pieceBoard.readBoard();
        chessboard.repaint();
        connectNet.client socket = new client();
        chessboard.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                black_select_x = (e.getX() - X_OFFSET) / PIECES_LENGTH_X;
                black_select_y = (e.getY() - Y_OFFSET) / PIECES_LENGTH_Y;
                charBoard.readChessBoardC();
                pieceBoard.readBoard();
                if (pieceBoard.checkWin()) {
                    if (charBoard.getCurrentPlayer() == 2) {//蓝方胜利
                        if (easyAi) {
                            manageUser.getUsers().get(LoginFrame.currentIndex).setWinNumber(manageUser.getUsers().get(LoginFrame.currentIndex).getWinNumber() + 1);
                            System.out.println(manageUser.getUsers().get(LoginFrame.currentIndex).getWinNumber() + "胜局");
                            manageUser.writeFile();
                        }
                        String message = "Blue Win";
                        System.out.println(message);
                        int confirm = JOptionPane.showConfirmDialog(gameFrame, message, "Result", JOptionPane.DEFAULT_OPTION);
                        if (confirm == JOptionPane.OK_OPTION) {
                            initBoardC();
                            if (timeCount != null) timeCount.stop();
                            if (!easyAi) {
                                timeCount = new TimeCount();
                                timeCount.start();
                            }
                        }
                    } else {//红方胜利
                        String message = "Red Win";
                        int confirm = JOptionPane.showConfirmDialog(gameFrame, message, "Result", JOptionPane.DEFAULT_OPTION);
                        if (confirm == JOptionPane.OK_OPTION) {
                            initBoardC();
                            if (timeCount != null) timeCount.stop();
                            if (!easyAi) {
                                timeCount = new TimeCount();
                                timeCount.start();
                            }
                        }
                    }
                }
                chessboard.repaint();
            }
        });
        chessboard.addMouseListener(new MouseAdapter() {
            boolean click = false;
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                charBoard.readChessBoardC();
                pieceBoard.readBoard();
                System.out.println(num);
                if (num == 1) {
                    black_select_x_conf = (e.getX() - X_OFFSET) / PIECES_LENGTH_X;
                    black_select_y_conf = (e.getY() - Y_OFFSET) / PIECES_LENGTH_Y;
                }
                if (charBoard.setFirstChoose() && num == 1) {
                    new clicked().startClick();
                    System.out.println("choose first right");
                    pieceBoard.getPos();
                    for (int i = 0; i < 4; i++) {
                        System.out.print(pieceBoard.pos[i][0]+" ");
                        System.out.println(pieceBoard.pos[i][1]);
                    }
                    chessboard.repaint();
                    num++;
                }else if(num==2){
                    black_select_x_conf_2 = (e.getX() - X_OFFSET) / PIECES_LENGTH_X;
                    black_select_y_conf_2 = (e.getY() - Y_OFFSET) / PIECES_LENGTH_Y;
                    if (charBoard.setSecondChoose()) {
                        new clicked().startClick();
                        System.out.println("choose second right");
                        pieceBoard.changeBoard();
                        pieceBoard.setPos_Default();
                        chessboard.repaint();
                        pieceBoard.writeBoard();
                        try {
                            charBoard.writeChessboardC();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        black_select_x_conf = -1;
                        black_select_y_conf = -1;
                        black_select_x_conf_2 = -1;
                        black_select_y_conf_2 = -1;
                        num = 1;}
                        //改变参数的值
                        c();
                        charBoard.setNextCurrentPlayer();
                    }
                click = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                click = false;
                if(c){
                    //发数据
                    try {
                        socket.sendDataToSocket();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    if (pieceBoard.checkWin()) {
                        if (charBoard.getCurrentPlayer() == 2) {//蓝方胜利
                            if (easyAi) {
                                manageUser.getUsers().get(LoginFrame.currentIndex).setWinNumber(manageUser.getUsers().get(LoginFrame.currentIndex).getWinNumber() + 1);
                                System.out.println(manageUser.getUsers().get(LoginFrame.currentIndex).getWinNumber() + "胜局");
                                manageUser.writeFile();
                            }
                            String message = "Blue Win";
                            System.out.println(message);
                            int confirm = JOptionPane.showConfirmDialog(gameFrame, message, "Result", JOptionPane.DEFAULT_OPTION);
                            if (confirm == JOptionPane.OK_OPTION) {
                                initBoardC();
                                if (timeCount != null) timeCount.stop();
                                if (!easyAi) {
                                    timeCount = new TimeCount();
                                    timeCount.start();
                                }
                            }
                        } else {//红方胜利
                            String message = "Red Win";
                            int confirm = JOptionPane.showConfirmDialog(gameFrame, message, "Result", JOptionPane.DEFAULT_OPTION);
                            if (confirm == JOptionPane.OK_OPTION) {
                                initBoardC();
                                if (timeCount != null) timeCount.stop();
                                if (!easyAi) {
                                    timeCount = new TimeCount();
                                    timeCount.start();
                                }
                            }
                        }
                    }else {
                    //收数据
                    try {
                        socket.receiveDateToSocket();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    charBoard.setNextCurrentPlayer();
                    c = false;
                }}
            }
        });
    }

    public class initHardAIGameFrame extends Thread {
        @Override
        public void run() {
            initGameFrame();
            chessboard.addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    boolean click = false;
                    if (isPlayHardAi) {
                        super.mousePressed(e);
                        charBoard.readChessBoard();
                        pieceBoard.readBoard();
                        System.out.println(num);
                        if (num == 1) {
                            black_select_x_conf = (e.getX() - X_OFFSET) / PIECES_LENGTH_X;
                            black_select_y_conf = (e.getY() - Y_OFFSET) / PIECES_LENGTH_Y;
                        }
                        if (charBoard.setFirstChoose() && num == 1) {
                            new clicked().startClick();
                            System.out.println("choose first right");
                            pieceBoard.getPos();
                            for (int i = 0; i < 4; i++) {
                                System.out.print(pieceBoard.pos[i][0] + " ");
                                System.out.println(pieceBoard.pos[i][1]);
                            }
                            chessboard.repaint();
                            num++;
                        } else if (num == 2) {
                            black_select_x_conf_2 = (e.getX() - X_OFFSET) / PIECES_LENGTH_X;
                            black_select_y_conf_2 = (e.getY() - Y_OFFSET) / PIECES_LENGTH_Y;
                            if (charBoard.setSecondChoose()) {
                                new clicked().startClick();
                                System.out.println("choose second right");
                                pieceBoard.changeBoard();
                                pieceBoard.setPos_Default();
                                chessboard.repaint();
                                if (pieceBoard.checkWin()) {
                                    if (charBoard.getCurrentPlayer() == 2) {//蓝方胜利
                                        if (isPlayHardAi) {
                                            manageUser.getUsers().get(LoginFrame.currentIndex).setWinNumber(manageUser.getUsers().get(LoginFrame.currentIndex).getWinNumber() + 2);
                                            System.out.println(manageUser.getUsers().get(LoginFrame.currentIndex).getWinNumber() + "胜局");
                                            manageUser.writeFile();
                                        }
                                        String message = "Blue Win";
                                        System.out.println(message);
                                        int confirm = JOptionPane.showConfirmDialog(gameFrame, message, "Result", JOptionPane.DEFAULT_OPTION);
                                        if (confirm == JOptionPane.OK_OPTION) {
                                            initBoard();
                                            if (timeCount != null) timeCount.stop();
                                            if (!easyAi) {
                                                timeCount = new TimeCount();
                                                timeCount.start();
                                            }
                                        }
                                    } else {//红方胜利
                                        String message = "Red Win";
                                        int confirm = JOptionPane.showConfirmDialog(gameFrame, message, "Result", JOptionPane.DEFAULT_OPTION);
                                        if (confirm == JOptionPane.OK_OPTION) {
                                            initBoard();
                                            if (timeCount != null) timeCount.stop();
                                            if (!easyAi) {
                                                timeCount = new TimeCount();
                                                timeCount.start();
                                            }
                                        }
                                    }
                                } else {
                                    pieceBoard.writeBoard();
                                    try {
                                        charBoard.writeChessboard();
                                    } catch (IOException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                    black_select_x_conf = -1;
                                    black_select_y_conf = -1;
                                    black_select_x_conf_2 = -1;
                                    black_select_y_conf_2 = -1;
                                    num = 1;
                                    charBoard.setNextCurrentPlayer();
                                    click = true;
                                }
                            }
                        }
                        if (click) {
                            System.out.println(charBoard.getCurrentPlayer());
                            charBoard.readChessBoard();
                            pieceBoard.readBoard();
                            System.out.println("HardAI");
                            ArrayList<Integer> canChooseX = new ArrayList<>();
                            ArrayList<Integer> canChooseY = new ArrayList<>();
                            for (int i = 0; i < 9; i++) {
                                for (int j = 0; j < 7; j++) {
                                    black_select_y_conf = i;
                                    black_select_x_conf = j;
                                    if (charBoard.setFirstChoose()) {
                                        canChooseY.add(i);
                                        canChooseX.add(j);
                                        System.out.println(i);
                                        System.out.println(j);
                                    }
                                }
                            }
                            for (int i = 0; i < canChooseX.size(); i++) {
                                System.out.print(charBoard.getCharBoard()[canChooseY.get(i)][canChooseX.get(i)]+" ");
                            }
                            ArrayList<ArrayList<Integer>> canMoveX = new ArrayList<>();
                            ArrayList<ArrayList<Integer>> canMoveY = new ArrayList<>();
                            for (int i = 0; i < canChooseX.size(); i++) {
                                black_select_y_conf = canChooseY.get(i);
                                black_select_x_conf = canChooseX.get(i);
                                pieceBoard.getPos();
                                ArrayList<Integer> x = new ArrayList<>();
                                ArrayList<Integer> y = new ArrayList<>();
                                for (int d = 0; d < 9; d++) {
                                    for (int j = 0; j < 7; j++) {
                                        black_select_y_conf_2 = d;
                                        black_select_x_conf_2 = j;
                                        if (charBoard.setSecondChoose()) {
                                            x.add(j);
                                            y.add(d);
                                        }
                                    }
                                }
                                canMoveX.add(x);
                                canMoveY.add(y);
                            }
                            List<ArrayList<Integer>> StepsValue = new ArrayList<>();
                            StepsValue = new model.HardAI().getValue(charBoard.getCharBoard(), canMoveX, canMoveY, canChooseX, canChooseY);
                            int x1 = 0;
                            int y1 = 0;
                            int x2 = 0;
                            int y2 = 0;
                            int temp = -2;
                            for (int i = 0; i < canMoveX.size(); i++) {
                                for (int d = 0; d < canMoveX.get(i).size(); d++) {
                                    int t = StepsValue.get(i).get(d);
                                    if (t > temp) {
                                        temp = t;
                                        x1 = canChooseX.get(i);
                                        y1 = canChooseY.get(i);
                                        x2 = canMoveX.get(i).get(d);
                                        y2 = canMoveY.get(i).get(d);
                                    }
                                }
                            }
                            black_select_y_conf = y1;
                            black_select_x_conf = x1;
                            black_select_y_conf_2 = y2;
                            black_select_x_conf_2 = x2;
                            System.out.println(black_select_y_conf);
                            System.out.println(black_select_x_conf);
                            System.out.println(black_select_y_conf_2);
                            System.out.println(black_select_x_conf_2);
                            pieceBoard.changeBoard();
                            pieceBoard.setPos_Default();
                            chessboard.repaint();
                            if (pieceBoard.checkWin()) {
                                if (charBoard.getCurrentPlayer() == 2) {//蓝方胜利
                                    if (isPlayEasyAi) {
                                        manageUser.getUsers().get(LoginFrame.currentIndex).setWinNumber(manageUser.getUsers().get(LoginFrame.currentIndex).getWinNumber() + 2);
                                        System.out.println(manageUser.getUsers().get(LoginFrame.currentIndex).getWinNumber() + "胜局");
                                        manageUser.writeFile();
                                    }
                                    String message = "Blue Win";
                                    System.out.println(message);
                                    int confirm = JOptionPane.showConfirmDialog(gameFrame, message, "Result", JOptionPane.DEFAULT_OPTION);
                                    if (confirm == JOptionPane.OK_OPTION) {
                                        initBoard();
                                        if (timeCount != null) timeCount.stop();
                                        if (!easyAi) {
                                            timeCount = new TimeCount();
                                            timeCount.start();
                                        }
                                    }
                                } else {//红方胜利
                                    String message = "Red Win";
                                    int confirm = JOptionPane.showConfirmDialog(gameFrame, message, "Result", JOptionPane.DEFAULT_OPTION);
                                    if (confirm == JOptionPane.OK_OPTION) {
                                        initBoard();
                                        if (timeCount != null) timeCount.stop();
                                        if (!easyAi) {
                                            timeCount = new TimeCount();
                                            timeCount.start();
                                        }
                                    }
                                }
                            } else {
                                pieceBoard.writeBoard();
                                try {
                                    charBoard.writeChessboard();
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }

                                black_select_x_conf = -1;
                            black_select_y_conf = -1;
                            black_select_x_conf_2 = -1;
                            black_select_y_conf_2 = -1;
                            num = 1;
                            charBoard.setNextCurrentPlayer();
                            click = false;}
                        }
                    }
                }
                @Override
                public void mouseReleased(MouseEvent e) {
                    super.mouseReleased(e);
                    click = false;
                }
            });

        }
    }

    public class initEasyAIGameFrame extends Thread {
        @Override
        public void run() {
            super.run();
            initGameFrame();
            chessboard.addMouseListener(new MouseAdapter() {
                boolean click = false;

                @Override
                public void mousePressed(MouseEvent e) {
                    if (isPlayEasyAi) {
                        super.mousePressed(e);
                        charBoard.readChessBoard();
                        pieceBoard.readBoard();
                        System.out.println(num);
                        if (num == 1) {
                            black_select_x_conf = (e.getX() - X_OFFSET) / PIECES_LENGTH_X;
                            black_select_y_conf = (e.getY() - Y_OFFSET) / PIECES_LENGTH_Y;
                            System.out.println(black_select_x_conf);
                            System.out.println(black_select_y_conf);
                        }
                        if (charBoard.setFirstChoose() && num == 1) {
                            new clicked().startClick();
                            System.out.println("choose first right");
                            pieceBoard.getPos();
                            for (int i = 0; i < 4; i++) {
                                System.out.print(pieceBoard.pos[i][0] + " ");
                                System.out.println(pieceBoard.pos[i][1]);
                            }
                            chessboard.repaint();
                            num++;
                        } else if (num == 2) {
                            black_select_x_conf_2 = (e.getX() - X_OFFSET) / PIECES_LENGTH_X;
                            black_select_y_conf_2 = (e.getY() - Y_OFFSET) / PIECES_LENGTH_Y;
                            if (charBoard.setSecondChoose()) {
                                new clicked().startClick();
                                System.out.println("choose second right");
                                pieceBoard.changeBoard();
                                pieceBoard.setPos_Default();
                                chessboard.repaint();
                                if (pieceBoard.checkWin()) {
                                    if (charBoard.getCurrentPlayer() == 2) {//蓝方胜利
                                        if (isPlayEasyAi) {
                                            manageUser.getUsers().get(LoginFrame.currentIndex).setWinNumber(manageUser.getUsers().get(LoginFrame.currentIndex).getWinNumber() + 1);
                                            System.out.println(manageUser.getUsers().get(LoginFrame.currentIndex).getWinNumber() + "胜局");
                                            manageUser.writeFile();
                                        }
                                        String message = "Blue Win";
                                        System.out.println(message);
                                        int confirm = JOptionPane.showConfirmDialog(gameFrame, message, "Result", JOptionPane.DEFAULT_OPTION);
                                        if (confirm == JOptionPane.OK_OPTION) {
                                            initBoard();
                                            if (timeCount != null) timeCount.stop();
                                            if (!easyAi) {
                                                timeCount = new TimeCount();
                                                timeCount.start();
                                            }
                                        }
                                    } else {//红方胜利
                                        String message = "Red Win";
                                        int confirm = JOptionPane.showConfirmDialog(gameFrame, message, "Result", JOptionPane.DEFAULT_OPTION);
                                        if (confirm == JOptionPane.OK_OPTION) {
                                            initBoard();
                                            if (timeCount != null) timeCount.stop();
                                            if (!easyAi) {
                                                timeCount = new TimeCount();
                                                timeCount.start();
                                            }
                                        }
                                    }
                                } else {
                                    pieceBoard.writeBoard();
                                    try {
                                        charBoard.writeChessboard();
                                    } catch (IOException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                    black_select_x_conf = -1;
                                    black_select_y_conf = -1;
                                    black_select_x_conf_2 = -1;
                                    black_select_y_conf_2 = -1;
                                    num = 1;
                                    charBoard.setNextCurrentPlayer();
                                    click = true;
                                    System.out.println(click + "jieguo");
                                }
                            }
                        }
                        if (click) {
                            charBoard.readChessBoard();
                            pieceBoard.readBoard();
                            System.out.println("EasyAI");
                            ArrayList<Integer> canChooseX = new ArrayList<>();
                            ArrayList<Integer> canChooseY = new ArrayList<>();
                            int L = 0;
                            for (int i = 0; i < 9; i++) {
                                for (int j = 0; j < 7; j++) {
                                    black_select_y_conf = i;
                                    black_select_x_conf = j;
                                    if (charBoard.setFirstChoose()) {
                                        canChooseY.add(i);
                                        canChooseX.add(j);
                                        L++;
                                    }
                                }
                            }
                            for (int i = 0; i < canChooseX.size(); i++) {
                                System.out.println(charBoard.getCharBoard()[canChooseX.get(i)][canChooseY.get(i)]);
                            }
                            Random r = new Random();
                            int R = r.nextInt(L);
                            black_select_x_conf = canChooseX.get(R);
                            black_select_y_conf = canChooseY.get(R);
                            pieceBoard.getPos();

                            int l = 0;
                            ArrayList<Integer> canMoveX = new ArrayList<>();
                            ArrayList<Integer> canMoveY = new ArrayList<>();
                            for (int i = 0; i < 9; i++) {
                                for (int j = 0; j < 7; j++) {
                                    black_select_y_conf_2 = i;
                                    black_select_x_conf_2 = j;
                                    if (charBoard.setSecondChoose()) {
                                        canMoveX.add(i);
                                        canMoveY.add(j);
                                        l++;
                                    }
                                }
                            }

                            int RR = r.nextInt(l);
                            black_select_y_conf_2 = canMoveX.get(RR);
                            black_select_x_conf_2 = canMoveY.get(RR);
                            pieceBoard.changeBoard();
                            pieceBoard.setPos_Default();
                            chessboard.repaint();
                            if (pieceBoard.checkWin()) {
                                if (charBoard.getCurrentPlayer() == 2) {//蓝方胜利
                                    if (isPlayEasyAi) {
                                        manageUser.getUsers().get(LoginFrame.currentIndex).setWinNumber(manageUser.getUsers().get(LoginFrame.currentIndex).getWinNumber() + 1);
                                        System.out.println(manageUser.getUsers().get(LoginFrame.currentIndex).getWinNumber() + "胜局");
                                        manageUser.writeFile();
                                    }
                                    String message = "Blue Win";
                                    System.out.println(message);
                                    int confirm = JOptionPane.showConfirmDialog(gameFrame, message, "Result", JOptionPane.DEFAULT_OPTION);
                                    if (confirm == JOptionPane.OK_OPTION) {
                                        initBoard();
                                        if (timeCount != null) timeCount.stop();
                                        if (!easyAi) {
                                            timeCount = new TimeCount();
                                            timeCount.start();
                                        }
                                    }
                                } else {//红方胜利
                                    String message = "Red Win";
                                    int confirm = JOptionPane.showConfirmDialog(gameFrame, message, "Result", JOptionPane.DEFAULT_OPTION);
                                    if (confirm == JOptionPane.OK_OPTION) {
                                        initBoard();
                                        if (timeCount != null) timeCount.stop();
                                        if (!easyAi) {
                                            timeCount = new TimeCount();
                                            timeCount.start();
                                        }
                                    }
                                }
                            }else {
                                pieceBoard.writeBoard();

                                try {
                                    charBoard.writeChessboard();
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                                black_select_x_conf = -1;
                                black_select_y_conf = -1;
                                black_select_x_conf_2 = -1;
                                black_select_y_conf_2 = -1;
                                num = 1;
                                charBoard.setNextCurrentPlayer();
                                click = false;
                            }
                        }
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    super.mouseReleased(e);
                }
            });
        }


    }
}