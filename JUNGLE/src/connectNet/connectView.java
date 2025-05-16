package connectNet;
import view.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class connectView {
    JFrame screen = new JFrame("Connect Confirm");
    JFrame init = new JFrame("Choose");
    JFrame Fail = new JFrame("Connect Fail");
    final int Height = 350;
    final int Width = 700;
    private String IP;
    public connectView(){}
    public void initServer() {
        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
        screen.setBounds((scrSize.width - Width) / 2, (scrSize.height - Height) / 2, Width, Height);
        //不可改变窗口大小
        screen.setResizable(false);
        //todo:还没加背景图片，但不加也没大问题吧

        Box vBox = Box.createVerticalBox();

        Box IP = Box.createHorizontalBox();
        JLabel IPLabel = new JLabel("Input IP(IPv4) : ");
        JTextField IPField = new JTextField(16);
        IP.add(Box.createHorizontalStrut(50));
        IP.add(IPLabel);
        IP.add(Box.createHorizontalStrut(20));
        IP.add(IPField);
        IP.add(Box.createHorizontalStrut(50));

        Box Port = Box.createHorizontalBox();
        JLabel pLabel = new JLabel("Input Port : ");
        JTextField pField = new JTextField(16);
        Port.add(Box.createHorizontalStrut(50));
        Port.add(pLabel);
        Port.add(Box.createHorizontalStrut(20));
        Port.add(pField);
        Port.add(Box.createHorizontalStrut(50));

        Box BBox = Box.createHorizontalBox();
        JButton OK = new JButton("Confirm");
        JButton Cancel = new JButton("Cancel");
        BBox.add(OK);
        BBox.add(Box.createHorizontalStrut(80));
        BBox.add(Box.createHorizontalStrut(80));
        BBox.add(Cancel);
        //TCP是要发出端发出信息，接受方发出已经准备好接受信息的回应，才能建立起通讯。
        //我也想用UDP，但用TCP的话，当数据没送到时你马上能知道没送到。是真的不想再多debug了
        OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String IPv4 = IPField.getText().trim();
                int Port = Integer.valueOf(pField.getText().trim());
                Connect C = new Connect(IPv4,Port);
                try {
                    C.record();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                    newRed b = new newRed();
                    Thread B = new Thread(b);
                    B.start();
            }
        });
        Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screen.dispose();
            }
        });

        vBox.add(Box.createVerticalStrut(50));
        vBox.add(IP);
        vBox.add(Box.createVerticalStrut(50));
        vBox.add(Port);
        vBox.add(Box.createVerticalStrut(50));
        vBox.add(BBox);
        vBox.add(Box.createVerticalStrut(50));

        screen.add(vBox);

        screen.setVisible(true);

    }
    public void initClient() {
        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
        screen.setBounds((scrSize.width - Width) / 2, (scrSize.height - Height) / 2, Width, Height);
        //不可改变窗口大小
        screen.setResizable(false);
        //todo:还没加背景图片，但不加也没大问题吧

        Box vBox = Box.createVerticalBox();

        Box IP = Box.createHorizontalBox();
        JLabel IPLabel = new JLabel("Input IP(IPv4) : ");
        JTextField IPField = new JTextField(16);
        IP.add(Box.createHorizontalStrut(50));
        IP.add(IPLabel);
        IP.add(Box.createHorizontalStrut(20));
        IP.add(IPField);
        IP.add(Box.createHorizontalStrut(50));

        Box Port = Box.createHorizontalBox();
        JLabel pLabel = new JLabel("Input Port : ");
        JTextField pField = new JTextField(16);
        Port.add(Box.createHorizontalStrut(50));
        Port.add(pLabel);
        Port.add(Box.createHorizontalStrut(20));
        Port.add(pField);
        Port.add(Box.createHorizontalStrut(50));

        Box BBox = Box.createHorizontalBox();
        JButton OK = new JButton("Confirm");
        JButton Cancel = new JButton("Cancel");
        BBox.add(OK);
        BBox.add(Box.createHorizontalStrut(80));
        BBox.add(Box.createHorizontalStrut(80));
        BBox.add(Cancel);
        //TCP是要发出端发出信息，接受方发出已经准备好接受信息的回应，才能建立起通讯。
        //我也想用UDP，但用TCP的话，当数据没送到时你马上能知道没送到。是真的不想再多debug了
        OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String IPv4 = IPField.getText().trim();
                int Port = Integer.valueOf(pField.getText().trim());
                Connect C = new Connect(IPv4,Port);
                try {
                    C.record();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                newBlue b = new newBlue();
                Thread B = new Thread(b);
                B.start();
            }
        });
        Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screen.dispose();
            }
        });

        vBox.add(Box.createVerticalStrut(50));
        vBox.add(IP);
        vBox.add(Box.createVerticalStrut(50));
        vBox.add(Port);
        vBox.add(Box.createVerticalStrut(50));
        vBox.add(BBox);
        vBox.add(Box.createVerticalStrut(50));

        screen.add(vBox);
        screen.setVisible(true);

    }
    public void Fail() {
        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
        Fail.setBounds((scrSize.width - Width) / 2, (scrSize.height - Height) / 2, Width, Height);
        //不可改变窗口大小
        Fail.setResizable(false);
        //todo:还没加背景图片，但不加也没大问题吧

        Box vBox = Box.createVerticalBox();
        Box o = Box.createHorizontalBox();
        Box t = Box.createHorizontalBox();
        JButton O = new JButton(" OK ");
        JLabel text = new JLabel("The room doesn't exist or connect fail, please try again");

        o.add(Box.createHorizontalStrut(50));
        o.add(O);
        o.add(Box.createHorizontalStrut(50));
        t.add(Box.createHorizontalStrut(50));
        t.add(text);
        t.add(Box.createHorizontalStrut(50));
        vBox.add(Box.createVerticalStrut(50));
        vBox.add(t);
        vBox.add(Box.createVerticalStrut(100));
        vBox.add(o);
        vBox.add(Box.createVerticalStrut(50));
        Fail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        O.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Fail.dispose();
            }
        });
        Fail.add(vBox);

        Fail.setVisible(true);}
}
