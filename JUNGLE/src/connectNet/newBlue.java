package connectNet;

import java.io.IOException;

public class newBlue implements Runnable{
    @Override
    public void run(){
        try {
            new view.GameFrame().initClient();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}