package Assignment2p2.q2;

import java.util.*;

public class ArrayListUsers {
    public static void main(String[] args) {
        ArrayList<Users> users = new ArrayList<>();
        users.add(new Users("Soham", 20));
        users.add(new Users("Ankush", 17));
        users.add(new Users("Zuanid", 18));
        users.add(new Users("Kushan", 21));
        users.add(new Users("Mizan", 19));
        Collections.sort(users,new Comparator<Users>(){
            public int compare(Users user1, Users user2){
                return Integer.compare(user1.getAge(), user2.getAge());
            }
        });
        for(Users user:users){
            System.out.println(user);
        }
    }
}