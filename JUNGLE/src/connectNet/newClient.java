package connectNet;

import java.io.IOException;

public class newClient implements Runnable{
    @Override
    public void run(){
        try {
            new client().ClientInit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
