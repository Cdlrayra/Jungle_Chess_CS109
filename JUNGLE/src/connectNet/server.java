package connectNet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public void SeverInit(){
        newServer ns = new newServer();
        Thread NS = new Thread(ns);
        NS.start();
    }
    BufferedReader br;
    BufferedWriter bw;
    private static int Port = 9763;

    public ServerSocket serverSocket = new ServerSocket(this.Port);;
    public Socket socket;
    public int getPort(){return this.Port;}

    public server() throws IOException {
            socket = serverSocket.accept();
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }
    public void receiveDateToSocket() throws IOException {
            String line = br.readLine();
            writeTxt(line);
    }
    public void sendDataToSocket() throws IOException {
        String text = readTxt();
        try {
            bw.write(text);
            bw.newLine();
            bw.flush();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public String readTxt(){
        File file = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//Files//chessboard(server)");//使用了相对位置
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
        String sent = targetStr.substring(targetStr.length()-68 ,targetStr.length());
        return sent;}
    public void writeTxt(String receive) throws IOException {

        File file = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//Files//chessboard(server)");
        FileWriter fileWriter= new FileWriter(file,true);
        int num = 0;
        fileWriter.write(receive.charAt(num));
        num++;
        fileWriter.write("\n");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++) {
                fileWriter.write(receive.charAt(num));
                num++;
            }
            fileWriter.write("\n");
        }
        for (int i =0; i<4; i++){
            fileWriter.write(receive.charAt(num));
            num++;
        }
        fileWriter.write("\n");
        fileWriter.close();
    }
}

