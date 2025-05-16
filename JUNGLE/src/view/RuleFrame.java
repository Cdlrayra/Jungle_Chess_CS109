package view;

import javax.swing.*;

public class RuleFrame {
    JFrame ruleFrame = new JFrame("PROJECT_2023_CS109SPRING_JUNGLE");
    private final int WIDTH = 550;
    private final int HEIGHT = 600;
    JTabbedPane tabbedPane= new JTabbedPane(SwingConstants.LEFT,JTabbedPane.SCROLL_TAB_LAYOUT);

    public void initRuleFrame(){
        ruleFrame.setBounds(300,300,WIDTH,HEIGHT);

        tabbedPane.addTab("Pieces",new JTextArea("---Pieces:\n" +
                "Each player owns 8 animal pieces representing different animals of\n" +
                "various ranks, and higher ranked animals can capture the animals of\n" +
                "lower or equal rank. But there is a special case that elephant cannot\n" +
                "capture the rat while the rat can capture the elephant.Each player\n" +
                "moves alternatively, and all pieces can move one square horizontally\n" +
                "or vertically, but not diagonally.As shown in the table, there are some\n" +
                "special movements for lion, tiger and rat. These will be explained in detail: \n" +
                "--- Entering the river: \n" +
                "The rat is the only animal that may go onto a water square. \n" +
                "After entering the river, the rat cannot be captured by any piece on \n" +
                "land. \n" +
                "Also, the rat in river cannot capture the elephant on the land. \n" +
                "Red rat can move to the square in green and cannot move to the square \n" +
                "in red. \n" +
                "--- Jumping across the river: \n" +
                "The lion and tiger can jump over a river vertically or horizontally.\n" +
                "They jump from a square on one edge of the river to the next non-water\n" +
                "square on the other side. \n" +
                "If that square contains an enemy piece of equal or lower rank, the lion\n" +
                "or tiger capture it as part of their jump. \n" +
                "However, a jumping move is blocked (not permitted) if a rat of either\n" +
                "color currently occupies any of the intervening water squares.\n"));
        tabbedPane.addTab("Chessboard",new JTextArea("---Chessboard \n" +
                "Jungle game has an interesting chessboard with different terrains\n" +
                "including dens, traps and rivers. After the initialization, the\n" +
                "pieces start on squares with pictures corresponding to their animals, \n" +
                "which are invariably shown on the Jungle board. \n" +
                "The three kinds of special terrains are explained as: \n" +
                "---Dens(兽穴): It is not allowed that the piece enters its own den. If \n" +
                "the player's piece enters the dens of his/her opponent, then the player \n" +
                "wins. \n" +
                "---Trap(陷阱): If a piece entering the opponents' trap, then its rank is \n" +
                "reduced into 0 ,temporarily before exiting. The trapped piece could be \n" +
                "captured by any pieces of the \n" +
                "defensing side. \n" +
                "---River(河流): They are located in the center of the chessboard, each \n" +
                "comprising 6 squares in a 2×3 rectangle. Only rats could enter the river, \n" +
                "and lions and tigers could jump across the river."));
        tabbedPane.addTab("Rules",new JTextArea("---Rules \n" +
                "1. Game Initialization: At the beginning, all 16 pieces are put into the \n" +
                "chessboard as the initial state. \n" +
                "2. Game Progress: The player with blue moves first. Two players take the \n" +
                "turn alternatively until the game is finished. When a player takes turn, \n" +
                "he/she can select one of his pieces and do one of the following: \n" +
                "-Moving one square horizontally or vertically. For lion, tiger and rat, \n" +
                "they also have special movements related to the river squares, which have \n" +
                "been introduced previously. \n" +
                "-Capturing an opposing piece. In all captures, the captured pieces is removed \n" +
                "from the board and the square is occupied by the capturing piece. A piece can \n" +
                "capture any enemy piece following the rules introduced in \"Pieces\". \n" +
                "3. Game Termination: A player loses the game if one of the following happens: \n" +
                "-The den is entered by his/her opponents. \n" +
                "-All of his/her pieces are captured and he/her is unable to do any movement.\n"));

        ruleFrame.add(tabbedPane);
        ruleFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new RuleFrame().initRuleFrame();
    }
}
