package view;

import connectNet.connectView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//制造进入特殊模式（联网和AI对战）的页面
public class SpecialFrame {
    JFrame Netscreen = new JFrame("Mode Choose");

    final int Height = 350;
    final int Width = 350;
    public void initNet() {
        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
        Netscreen.setBounds((scrSize.width - Width) / 2, (scrSize.height - Height) / 2, Width, Height);
        //不可改变窗口大小
        Netscreen.setResizable(false);
        //todo:没加背景图片

        Box vBox = Box.createVerticalBox();
        JButton a = new JButton("Creating a new game");
        JButton Cancel = new JButton("            Cancel              ");
        JButton b = new JButton("  Attend a new game  ");
        JButton c = new JButton("     witness a game     ");

        Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Netscreen.dispose();
                new view.GameChooseFrame();
            }
        });
        a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Netscreen.dispose();
                new connectView().initServer();
            }
        });
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Netscreen.dispose();
                new connectView().initClient();
            }
        });
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Netscreen.dispose();
                JOptionPane.showMessageDialog(null, "暂不支持", "Wrong load", JOptionPane.WARNING_MESSAGE);//棋盘错误
            }
        });

        vBox.add(Box.createVerticalStrut(15));
        vBox.add(a);
        vBox.add(Box.createVerticalStrut(50));
        vBox.add(b);
        vBox.add(Box.createVerticalStrut(50));
        vBox.add(c);
        vBox.add(Box.createVerticalStrut(50));
        vBox.add(Cancel);
        vBox.add(Box.createVerticalStrut(50));
        vBox.add(Box.createVerticalStrut(50));

        Box hBox = Box.createHorizontalBox();
        hBox.add(Box.createHorizontalStrut(95));
        hBox.add(vBox);
        hBox.add(Box.createHorizontalStrut(95));

        Netscreen.add(hBox);
        Netscreen.setVisible(true);
    }

}
