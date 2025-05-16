package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class LoginFrame {


    public LoginFrame() throws IOException {
    }

    enum loginEnum {
        FRAMEWIDTH(500),FRAMEHEIGHT(309);
        private int length;

        public int getLength() {
            return length;
        }

        loginEnum(int length) {
            this.length = length;
        }
    }
    JFrame loginFrame = new JFrame("PROJECT_2023_CS109SPRING_JUNGLE");
    backGroundJPanel loginPanel = new backGroundJPanel(ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//image//img//login.1.png")),loginEnum.FRAMEWIDTH.getLength(), loginEnum.FRAMEHEIGHT.getLength());
    Box verticalBox =Box.createVerticalBox();
    Box upperBox = Box.createHorizontalBox();
    Box lowerBox = Box.createHorizontalBox();
    Box bottomBox = Box.createHorizontalBox();

    JLabel upperLabel = new JLabel("User Name:");
    JLabel lowerLabel = new JLabel("Password:");
    JTextField upperTf= new JTextField(20);
    JTextField lowerTf = new JTextField(20);
    JButton loginButton = new JButton("Login");
    JButton registerButton =new JButton("Register");
    public static int currentIndex;

    public void initLoginFrame(){
        try {
            manageUser.readFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        loginFrame.setBounds(500,350,loginEnum.FRAMEWIDTH.getLength(), loginEnum.FRAMEHEIGHT.getLength());

        upperBox.add(upperLabel);
        upperBox.add(Box.createHorizontalStrut(20));
        upperBox.add(upperTf);

        lowerBox.add(lowerLabel);
        lowerBox.add(Box.createHorizontalStrut(28));
        lowerBox.add(lowerTf);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i <manageUser.getUsers().size(); i++) {
                    if(manageUser.getUsers().get(i).getUser_name().equals(upperTf.getText())){

                        if(manageUser.getUsers().get(i).getPassword().equals(lowerTf.getText())){
                            currentIndex=i;
                            System.out.println(manageUser.getUsers().get(i));
                            //Todo:跳转主界面；
                            try {
                                new MainFrame().initMainFrame();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            try {
                                manageUser.readFile();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            loginFrame.dispose();
                            break;
                        }
                        else {
                            JOptionPane.showMessageDialog(loginFrame,"Your password is wrong! Please try again!");
                            break;
                        }
                    }
                    if(i==manageUser.getUsers().size()-1){JOptionPane.showMessageDialog(loginFrame,"Your message is wrong! Please try again!");}
                }


            }
        });
        bottomBox.add(loginButton);
        bottomBox.add(Box.createHorizontalStrut(50));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO:跳转到注册页面；
                try {
                    new registerFrame().initRegisterFrame();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                loginFrame.dispose();
            }
        });
        bottomBox.add(registerButton);

        verticalBox.add(Box.createVerticalStrut(70));
        verticalBox.add(upperBox);
        verticalBox.add(Box.createVerticalStrut(15));
        verticalBox.add(lowerBox);
        verticalBox.add(Box.createVerticalStrut(10));
        verticalBox.add(bottomBox);

        loginPanel.add(verticalBox);
        loginFrame.add(loginPanel);
        loginFrame.setVisible(true);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        try {
            new LoginFrame().initLoginFrame();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


