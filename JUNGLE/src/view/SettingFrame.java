package view;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import music.*;
import view.GameFrame;
public class SettingFrame {
    JFrame settingFrame = new JFrame("PROJECT_2023_CS109SPRING_JUNGLE");
    JPanel musicPanel = new JPanel();
    ButtonGroup musicBg = new ButtonGroup();
    JRadioButton button1 = new JRadioButton();
    JRadioButton button2 = new JRadioButton();
    JPanel sound_effectPanel = new JPanel();
    ButtonGroup sound_effectBg = new ButtonGroup();
    JRadioButton button3 = new JRadioButton();
    JRadioButton button4 = new JRadioButton();
    JPanel theme_selectPanel = new JPanel();
    ButtonGroup theme_selectBg = new ButtonGroup();
    JRadioButton themeButton1 = new JRadioButton("Theme_1",new ImageIcon("C://Users//Lenovo//IdeaProjects//JUNGLE//src//image/img2/chessboard1.png"));
    JRadioButton themeButton2 = new JRadioButton("Theme_2",new ImageIcon("C://Users//Lenovo//IdeaProjects//JUNGLE//src//image/img2/chessboard2.png"));
    JRadioButton themeButton3 = new JRadioButton("Theme_3",new ImageIcon("C://Users//Lenovo//IdeaProjects//JUNGLE//src//image/img2/chessboard3.png"));
    JRadioButton themeButton4 = new JRadioButton("Theme_4",new ImageIcon("C://Users//Lenovo//IdeaProjects//JUNGLE//src//image/img2/chessboard4.png"));
    JRadioButton themeButton5 = new JRadioButton("Theme_5",new ImageIcon("C://Users//Lenovo//IdeaProjects//JUNGLE//src//image/img2/chessboard5.png"));

    JButton confirmBtn = new JButton("Confirm");
    JButton cancelBtn = new JButton("Cancel");
    Box verticalBox = Box.createVerticalBox();
    Box horizontalBox = Box.createHorizontalBox();

    Box outerBox = Box.createVerticalBox();
     public void initSettingFrame(){
         settingFrame.setBounds(300,200,400,700);

         sound_effectPanel.setBorder(new TitledBorder(new EtchedBorder(),"Choose Sound Effect"));
         button3.setText("Yes");
         button4.setText("No");
         sound_effectBg.add(button3);
         sound_effectBg.add(button4);
         sound_effectPanel.add(button3);
         sound_effectPanel.add(button4);

         musicPanel.setBorder(new TitledBorder(new EtchedBorder(),"Choose Music"));
         button1.setText("Yes");
         button2.setText("No");
         musicBg.add(button1);
         musicBg.add(button2);
         musicPanel.add(button1);
         musicPanel.add(button2);

         theme_selectPanel.setBorder(new TitledBorder(new EtchedBorder(),"Choose Theme"));
         theme_selectBg.add(themeButton1);
         theme_selectBg.add(themeButton2);
         theme_selectBg.add(themeButton3);
         theme_selectBg.add(themeButton4);
         theme_selectBg.add(themeButton5);
         theme_selectPanel.add(themeButton1);
         theme_selectPanel.add(themeButton2);
         theme_selectPanel.add(themeButton3);
         theme_selectPanel.add(themeButton4);
         theme_selectPanel.add(themeButton5);

         verticalBox.add(Box.createVerticalStrut(10));
         verticalBox.add(musicPanel);
         verticalBox.add(Box.createVerticalStrut(5));
         verticalBox.add(sound_effectPanel);
         verticalBox.add(Box.createVerticalStrut(5));
         verticalBox.add(theme_selectPanel);

         confirmBtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                  if(button1.isSelected()){
                      //todo:播放音乐；
                      new musicPlay().startMusic();
                      System.out.println(button1.isSelected());
                  }else {new musicPlay().stopMusic();}
                  if(button3.isSelected()){
                      //todo:添加棋子音效；
                      clicked.setIsPlay(true);
                      System.out.println(button3.isSelected());
                  }else {
                      new clicked().stopClick();
                  }

                  if(themeButton1.isSelected()){
                      //todo:设置背景图片为pic1;
                      GameFrame.select_chessBoard=0;
                      System.out.println(1);
                  }else if(themeButton2.isSelected()) {
                      System.out.println(2);
                      GameFrame.select_chessBoard=1;
                  }else if(themeButton3.isSelected()){
                      System.out.println(3);
                      GameFrame.select_chessBoard=2;
                  }else if(themeButton4.isSelected()){
                      System.out.println(4);
                      GameFrame.select_chessBoard=3;
                  }else if(themeButton5.isSelected()){
                      System.out.println(5);
                      GameFrame.select_chessBoard=4;
                  }else {
                      //todo:默认设置为pic1
                      GameFrame.select_chessBoard=0;
                      System.out.println("默认设置");
                  }
                  GameFrame.chessboard.repaint();
                 settingFrame.dispose();
             }
         });
         cancelBtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 settingFrame.dispose();
             }
         });
         horizontalBox.add(confirmBtn);
         horizontalBox.add(Box.createHorizontalStrut(30));
         horizontalBox.add(cancelBtn);

         outerBox.add(verticalBox);
         outerBox.add(Box.createVerticalStrut(10));
         outerBox.add(horizontalBox);

         settingFrame.add(outerBox);
         settingFrame.setVisible(true);
     }

    public static void main(String[] args) {
        new SettingFrame().initSettingFrame();
    }

}
