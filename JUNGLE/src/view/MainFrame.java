package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame {
    private final int WIDTH=500;
    private final int HEIGHT=650;

    JFrame mainFrame = new JFrame("PROJECT_2023_CS109SPRING_JUNGLE");

    backGroundJPanel mainPanel = new backGroundJPanel(ImageIO.read(new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//image/img/mainpicture.png")), WIDTH, HEIGHT);
    public MainFrame() throws IOException {
    }
    JButton ruleBtn = new JButton("     Rule      ",new ImageIcon("C://Users//Lenovo//IdeaProjects//JUNGLE//src//image/img/说明规则(1).png"));
    JButton rankBtn = new JButton("     Rank     ",new ImageIcon("C://Users//Lenovo//IdeaProjects//JUNGLE//src//image/img/排行榜.png"));
    JButton settingBtn = new JButton("    Setting   ",new ImageIcon("C://Users//Lenovo//IdeaProjects//JUNGLE//src//image/img/设置1.png"));
    JButton gameStartBtn = new JButton("Start Game",new ImageIcon("C://Users//Lenovo//IdeaProjects//JUNGLE//src//image/img/startgame.png"));

     Box verticalBox = Box.createVerticalBox();
    public void initMainFrame(){
        manageUser.rankUser();
        mainFrame.setBounds(600,200,WIDTH,HEIGHT);

         ruleBtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                new RuleFrame().initRuleFrame();
             }
         });

         rankBtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                new RankFrame().initRankFrame();
             }
         });

         settingBtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                new SettingFrame().initSettingFrame();
             }
         });

         gameStartBtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 new GameChooseFrame().initGameChooseFrame();
                 mainFrame.dispose();
             }
         });

        verticalBox.add(Box.createVerticalStrut(180));
        verticalBox.add(ruleBtn);
        verticalBox.add(Box.createVerticalStrut(20));
        verticalBox.add(rankBtn);
        verticalBox.add(Box.createVerticalStrut(20));
        verticalBox.add(settingBtn);
        verticalBox.add(Box.createVerticalStrut(20));
        verticalBox.add(gameStartBtn);

        mainPanel.add(verticalBox);
        mainFrame.add(mainPanel);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        try {

            manageUser.rankUser();
            new MainFrame().initMainFrame();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
