package view;

import javax.swing.*;
import java.io.IOException;

public class RankFrame {
    JFrame rankFrame =  new JFrame("PROJECT_2023_CS109SPRING_JUNGLE");
    String[] firstTitle = {"Rank","User name"," Games Score"};

    Object[][] data = {
            {1,manageUser.getRankUsers().get(0).getUser_name(),manageUser.getRankUsers().get(0).getWinNumber()},
            {2,manageUser.getRankUsers().get(1).getUser_name(),manageUser.getRankUsers().get(1).getWinNumber()},
            {3,manageUser.getRankUsers().get(2).getUser_name(),manageUser.getRankUsers().get(2).getWinNumber()},
            {4,manageUser.getRankUsers().get(3).getUser_name(),manageUser.getRankUsers().get(3).getWinNumber()},
            {5,manageUser.getRankUsers().get(4).getUser_name(),manageUser.getRankUsers().get(4).getWinNumber()}
    };

    JTable table = new JTable(data,firstTitle);
    public void initRankFrame(){
        manageUser.rankUser();
        rankFrame.add(table);
        rankFrame.setBounds(400,400,450,278);
        rankFrame.setVisible(true);
    }

    public static void main(String[] args) {

        manageUser.rankUser();
        new RankFrame().initRankFrame();
    }
}
