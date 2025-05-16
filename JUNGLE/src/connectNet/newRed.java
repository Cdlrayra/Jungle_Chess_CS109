package connectNet;

import java.io.IOException;

public class newRed implements Runnable{
    @Override
    public void run(){
        try {
            new view.GameFrame().initServer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
