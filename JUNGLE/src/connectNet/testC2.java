package connectNet;

import java.io.IOException;

public class testC2 {
    public static void main(String[] args) throws IOException {
        newBlue b = new newBlue();
        Thread B = new Thread(b);
        B.start();
    }
}
