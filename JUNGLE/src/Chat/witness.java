package Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;


public class witness extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new witness();
    }

    private JTextArea jta;
    private JScrollPane jsp;
    private JPanel jp;
    private JTextField jtf;
    private JButton jb;
    BufferedReader br;
    BufferedWriter bw;

    private static String clientIP;

    public void setIP(){
        File file = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src\\connectNet\\IP(server)");
        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        StringBuilder str = new StringBuilder();
        int len = 0;
        try {
            len = (int) fileReader.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (len != -1) {
            str.append((char) len);
            try {
                len = (int) fileReader.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        String newStr = str.toString();
        String targetStr = newStr.replaceAll("\\s*", "");
        this.clientIP= targetStr;
    }

    public witness(){
        setIP();
        jta = new JTextArea();
        jta.setEditable(false);
        jsp = new JScrollPane(jta);
        jp = new JPanel();
        jtf = new JTextField(15);
        jb = new JButton("sent");
        jp.add(jtf);
        jp.add(jb);

        this.add(jsp, BorderLayout.CENTER);
        this.add(jp, BorderLayout.SOUTH);
        this.setTitle("Witness");
        this.setSize(300,400);
        this.setLocation(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        jb.addActionListener(this);
        try {
            Socket socket = new Socket(clientIP, 10000);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String line;
            while ((line=br.readLine())!=null){
                jta.append(line+System.lineSeparator());
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sendDataToSocket();
    }

    private void sendDataToSocket(){
        String text = jtf.getText();

        text = "the Witness : " + text;

        jta.append(text+System.lineSeparator());

        try {
            bw.write(text);
            bw.newLine();
            bw.flush();
            jtf.setText("");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

