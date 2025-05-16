package view;

import java.io.*;
import java.util.ArrayList;

public class manageUser {

    public static ArrayList<user> users= new ArrayList<user>() ;
    private static ArrayList<user> rankUsers= new ArrayList<user>();
    public static ArrayList<user> rankUsers_copy= new ArrayList<user>();

    private static ArrayList<Integer> rankWinNum = new ArrayList<Integer>();

    public static ArrayList<user> getRankUsers() {
        return rankUsers;
    }


    public static void addUsers(user user)  {
        users.add(user);
        //todo:修改文件user；
        File addUser = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//Files//user1");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(addUser,true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.write(" "+user.getUser_name()+" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.write(user.getPassword()+" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.write(user.getWinNumber()+" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void writeFile() {

        //todo:修改文件user；
        File reWriteFile = new File("C://Users//Lenovo//IdeaProjects//JUNGLE//src//Files//user1");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(reWriteFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < users.size(); i++) {
            try {
                fileWriter.write( users.get(i).getUser_name() + " ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                fileWriter.write(users.get(i).getPassword() + " ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                fileWriter.write(users.get(i).getWinNumber() + " ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void readFile() throws IOException {
        users.clear();
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

    public static ArrayList<user> getRankUsers_copy() {
        return rankUsers_copy;
    }

    public static void rankUser(){//todo:该写法有缺陷，需要改进，问题主要是可能会把胜利局数相同的不同用户在列表中显示的用户名显示为同一个用户
        rankUsers.clear();
        rankUsers_copy.clear();
        rankWinNum.clear();
        for (int i = 0; i < users.size(); i++) {
            rankWinNum.add(users.get(i).getWinNumber());
            rankUsers_copy.add(users.get(i));
        }
        int[] rankNum = new int[rankWinNum.size()];
        for (int i = 0; i < rankNum.length; i++) {
            rankNum[i]=rankWinNum.get(i);
        }

        int temp = 0 ;
        for (int i = 0; i < rankNum.length-1; i++) {
            for (int j = rankNum.length-1; j > i; j--) {
                 if(rankNum[j]>rankNum[j-1]){
                     temp = rankNum[j];
                     rankNum[j]=rankNum[j-1];
                     rankNum[j-1]=temp;
                    }

                }
            }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < rankUsers_copy.size(); j++) {
                if(rankNum[i]==rankUsers_copy.get(j).getWinNumber()){
                    rankUsers.add(rankUsers_copy.get(j));
                    if(rankUsers_copy.size()==2){}else {
                        rankUsers_copy.remove(j);}
                    break;
                    }
                }
            }
        }

    public static ArrayList<user> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<user> users) {
        manageUser.users = users;
    }

    public static void main(String[] args) throws IOException {
        readFile();
        rankUser();
    }
}
