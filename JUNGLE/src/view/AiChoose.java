package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AiChoose {
    JFrame AiChooseFrame = new JFrame("PROJECT_2023_CS109SPRING_JUNGLE");
    JPanel AiChoosePanel = new JPanel();
    JButton EasyBtn = new JButton("  Easy  ");
    JButton HardBtn = new JButton("  Hard   ");
    Box vBox =Box.createVerticalBox();
    public void initAiChooseFrame(){
        AiChooseFrame.setBounds(650,450,300,300);
        AiChoosePanel.setBounds(750,600,100,100);
        EasyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo:跳转游戏界面；设置一下游戏模式；
                GameFrame gf = new GameFrame();
                gf.startEasyAI();
                AiChooseFrame.dispose();
            }
        });
        HardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo:困难模式
                GameFrame gf = new GameFrame();
                gf.startHardAI();
                AiChooseFrame.dispose();
            }
        });
        vBox.add(Box.createVerticalStrut(50));
        vBox.add(EasyBtn);
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(HardBtn);
        AiChoosePanel.add(vBox);
        AiChooseFrame.add(AiChoosePanel);
        AiChooseFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new AiChoose().initAiChooseFrame();
    }
}
