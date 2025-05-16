package music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class clicked {
    File file = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//image/click.wav");
    AudioInputStream click;

    {
        try {
            click = AudioSystem.getAudioInputStream(file);
        } catch (UnsupportedAudioFileException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    AudioFormat clickFormat = click.getFormat();
    SourceDataLine clickData;

    {
        try {
            clickData = AudioSystem.getSourceDataLine(clickFormat);
        } catch (LineUnavailableException ex) {
            throw new RuntimeException(ex);
        }
    }
    private static PlayThread playThread_click;
    private static boolean isPlay;

    public static void setIsPlay(boolean isPlay) {
        clicked.isPlay = isPlay;
    }

    public void startClick(){
        synchronized (this){
            playThread_click = new PlayThread();
            playThread_click.start();
            }
    }

    public void stopClick(){
        if(playThread_click==null){}
        else {isPlay=false;}
    }
    public class PlayThread extends Thread {

        @Override
        public void run() {

            try {
                clickData.open();
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            }


            clickData.start();

            int sumByteRead = 0;
            byte[] b = new byte[20];

            while (sumByteRead != -1 && isPlay) {
                try {
                    sumByteRead = click.read(b, 0, b.length);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (sumByteRead >= 0) {
                    clickData.write(b, 0, b.length);

                }
            }
            clickData.drain();
            clickData.close();
        }
    }

    public static void main(String[] args) {
        setIsPlay(true);
        new clicked().startClick();
    }

}
