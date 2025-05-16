package connectNet;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class client {
    public void ClientInit(){
        newClient nc = new newClient();
        Thread NC = new Thread(nc);
        NC.start();
    }
    BufferedReader br;
    BufferedWriter bw;
    private static String clientIP;
    private static int Port = 9763;

    Socket socket = null;

    public void setIP(){
        File file = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//connectNet//IP(server)");
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

    public int getPort(){return this.Port;}

    public client() throws IOException {
        setIP();
        this.socket = new Socket(clientIP, this.Port);
        bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void receiveDateToSocket() throws IOException {
        InputStream is = socket.getInputStream();
        byte[]bys = new byte[1024];
        int len = is.read(bys);
        String str = new String(bys,0,len);
        if(str!=null){writeTxt(str);}
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

    public static String readTxt(){
        File file = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//Files//chessboard(client)");//使用了相对位置
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
        return sent;
    }
    public static void writeTxt(String receive) throws IOException {

        File file = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//Files//chessboard(client)");
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

