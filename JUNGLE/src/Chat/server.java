package Chat;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
    public class server extends JFrame implements ActionListener {

        public static void main(String[] args) {
            new server();
        }
        public static ServerInit serverInit;
        public static void startS(){
             serverInit = new ServerInit();
             serverInit.start();
        }
        public static class ServerInit extends Thread{
            @Override
            public void run() {
                super.run();
                new server();
            }
        }
        private JTextArea jta;
        private JScrollPane jsp;
        private JPanel jp;
        private JTextField jtf;
        private JButton jb;
        BufferedReader br;
        BufferedWriter bw;

        public server(){
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
            this.setTitle("Server");
            this.setSize(300,400);
            this.setLocation(600,300);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
            jb.addActionListener(this);
            try {
                ServerSocket serverSocket = new ServerSocket(10000);
                Socket socket = serverSocket.accept();
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String line;
                while ((line=br.readLine())!=null){
                    jta.append(line+System.lineSeparator());
                }
                serverSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            sendDataToSocket();
        }
        public void sendDataToSocket(){
            String text = jtf.getText();
            text = "the Server : "+text;
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

