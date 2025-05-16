package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class registerFrame {
    public registerFrame() throws IOException {

    }
    JFrame registerFrame = new JFrame("PROJECT_2023_CS109SPRING_JUNGLE");
    private final int WIDTH=500;
    private final int HEIGHT=309;

    backGroundJPanel registerPanel = new backGroundJPanel(ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//image//img//login.1.png")), LoginFrame.loginEnum.FRAMEWIDTH.getLength(), LoginFrame.loginEnum.FRAMEHEIGHT.getLength());
    Box verticalBox =Box.createVerticalBox();
    Box upperBox = Box.createHorizontalBox();
    Box lowerBox = Box.createHorizontalBox();
    Box bottomBox = Box.createHorizontalBox();

    JLabel upperLabel = new JLabel("User Name:");
    JLabel lowerLabel = new JLabel("Password:");
    JTextField upperTf= new JTextField(18);
    JTextField lowerTf = new JTextField(20);
    JButton ReturnLoginButton = new JButton("Return to login interface");
    JButton registerButton =new JButton("Register");

    public void initRegisterFrame(){
        registerFrame.setBounds(500,350,WIDTH,HEIGHT);
        upperBox.add(upperLabel);
        upperBox.add(Box.createHorizontalStrut(21));
        upperBox.add(upperTf);

        lowerBox.add(lowerLabel);
        lowerBox.add(Box.createHorizontalStrut(28));
        lowerBox.add(lowerTf);

        ReturnLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new LoginFrame().initLoginFrame();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                registerFrame.dispose();
            }
        });
        bottomBox.add(ReturnLoginButton);

        bottomBox.add(Box.createHorizontalStrut(50));

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageUser.addUsers(new user(upperTf.getText(),lowerTf.getText(),0));
                try {
                    new LoginFrame().initLoginFrame();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                registerFrame.dispose();
            }
        });
        bottomBox.add(registerButton);

        verticalBox.add(Box.createVerticalStrut(70));
        verticalBox.add(upperBox);
        verticalBox.add(Box.createVerticalStrut(15));
        verticalBox.add(lowerBox);
        verticalBox.add(Box.createVerticalStrut(10));
        verticalBox.add(bottomBox);

        registerPanel.add(verticalBox);
        registerFrame.add(registerPanel);
        registerFrame.setVisible(true);
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        try {
            new registerFrame().initRegisterFrame();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


