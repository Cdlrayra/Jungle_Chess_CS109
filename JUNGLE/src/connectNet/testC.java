package connectNet;

import java.io.IOException;

public class testC {
    public static void main(String[] args) throws IOException {
        newRed b = new newRed();
        Thread B = new Thread(b);
        B.start();
    }
}
