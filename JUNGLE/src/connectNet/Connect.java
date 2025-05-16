package connectNet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


//使用的是TCP协议,要两边电脑连接上才能运行.这个class是用来确认两边是否成功连接上的
public class Connect {
    public String IP;
    public boolean c = false;
    public Connect(String IP,int Port){
        this.IP = IP;
        this.Port = Port;
    }
    public String getIP(){
        return this.IP;
    }
    public int Port;
    public int getPort(){return this.Port;}
    public void record () throws IOException {
        File file = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//connectNet//IP(server)");//用的相对位置，这样传输文件后就不用苦苦改路径了，大概。
        String ip = this.IP;

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("");
        fileWriter.flush();
        fileWriter.close();

        FileWriter fW = new FileWriter(file);
        fW.write(ip+"\n");
        fW.close();

        File File = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//connectNet//Port");//用的相对位置，这样传输文件后就不用苦苦改路径了，大概。
        int port = this.Port;

        FileWriter fileW2 = new FileWriter(File);
        fileW2.write("");
        fileW2.flush();
        fileW2.close();

        FileWriter fw2 = new FileWriter(File);
        fw2.write(port+"\n");
        fw2.close();
    }
}
