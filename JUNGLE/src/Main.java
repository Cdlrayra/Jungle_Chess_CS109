import view.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static view.manageUser.users;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        File file = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//Files//user1");
        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        StringBuilder newUsers = new StringBuilder();
        int length = 0;
        try {
            length = fileReader.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (length!=-1){
            newUsers.append((char)length);
            try {
                length=fileReader.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String new__Users = newUsers.toString();
        System.out.println(new__Users);
        String[] strings = new__Users.split(" ");
        for (int i = 0; i < strings.length/3; i++) {
            int winNum = Integer.parseInt(strings[i*3+2]);
            users.add(new user(strings[i*3],strings[i*3+1],winNum));
        }
        try {
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}