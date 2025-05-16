package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameChooseFrame {
    JFrame gameChooseFrame = new JFrame("PROJECT_2023_CS109SPRING_JUNGLE");
    JPanel gameChoosePanel = new JPanel();
    JButton ppBtn = new JButton(" PVP Mode    ");
    JButton pmBtn = new JButton(" PVE Mode    ");
    JButton piBtn = new JButton("Online  Mode");
    Box vBox =Box.createVerticalBox();
    public void initGameChooseFrame(){
        gameChooseFrame.setBounds(650,450,300,300);
        gameChoosePanel.setBounds(750,600,100,100);
        ppBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo:跳转游戏界面；设置一下游戏模式；
                GameFrame gf = new GameFrame();
                GameFrame.isPlayTimer=true;
                gf.startPVP();
                gameChooseFrame.dispose();
            }
        });
        pmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo:跳转游戏界面;更改游戏模式
                new  AiChoose().initAiChooseFrame();
                gameChooseFrame.dispose();
                GameFrame.isPlayTimer=false;
            }
        });
        piBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo:联网对战
                new SpecialFrame().initNet();
                GameFrame.isPlayTimer=false;
                gameChooseFrame.dispose();
            }
        });
        vBox.add(Box.createVerticalStrut(50));
        vBox.add(ppBtn);
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(pmBtn);
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(piBtn);
        gameChoosePanel.add(vBox);
        gameChooseFrame.add(gameChoosePanel);
        gameChooseFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new GameChooseFrame().initGameChooseFrame();
    }
}
