 package music;
 import java.io.File;
 import java.io.IOException;
 import javax.sound.sampled.*;
 public class musicPlay{
     File file = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//image/bgm.wav");
     AudioInputStream bgm;

     {
         try {
             bgm = AudioSystem.getAudioInputStream(file);
         } catch (UnsupportedAudioFileException ex) {
             throw new RuntimeException(ex);
         } catch (IOException ex) {
             throw new RuntimeException(ex);
         }
     }


     AudioFormat bgmFormat = bgm.getFormat();
     SourceDataLine bgmData;

     {
         try {
             bgmData = AudioSystem.getSourceDataLine(bgmFormat);
         } catch (LineUnavailableException ex) {
             throw new RuntimeException(ex);
         }
     }
     private static PlayThread playThread;
     private static boolean isPlay;

     public void startMusic(){
          synchronized (this){playThread = new PlayThread();
          playThread.start();
          isPlay=true;}
     }

     public void stopMusic(){
         if(playThread==null){isPlay=false;}
         else {isPlay=false;}
     }
     public class PlayThread extends Thread {

         @Override
         public void run() {

             try {
                 bgmData.open();
             } catch (LineUnavailableException e) {
                 throw new RuntimeException(e);
             }


             bgmData.start();

             int sumByteRead = 0;
             byte[] b = new byte[500];

             while (sumByteRead != -1 && isPlay) {
                 try {
                     sumByteRead = bgm.read(b, 0, b.length);
                 } catch (IOException e) {
                     throw new RuntimeException(e);
                 }
                 if (sumByteRead >= 0) {
                     bgmData.write(b, 0, b.length);

                 }
             }
                 bgmData.drain();
                 bgmData.close();
             }
         }



     public static void main(String[] args) {
          new musicPlay().startMusic();
     }
 }

