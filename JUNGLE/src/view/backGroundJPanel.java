package view;

import javax.swing.*;
import java.awt.*;

public class backGroundJPanel extends JPanel {
    private Image backGround ;
    private int width;
    private int height;
    public backGroundJPanel(Image backGround,int width,int height) {
        this.backGround = backGround;
        this.width = width;
        this.height= height;

    }
    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        graphics.drawImage(backGround,0,0,width,height,null);
    }


}
