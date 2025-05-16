package connectNet;

import java.io.IOException;

public class newServer implements Runnable{
    @Override
    public void run(){
        try {
            new server().SeverInit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
