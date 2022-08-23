package pl.coderslab.users;

import java.util.Arrays;

public class MainDao {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        User user1 = new User();
        user1.setUsername("John98");
        user1.setEmail("john98@hmail.net");
        user1.setPassword("rijjOOU^&jhfgiYYT");
        userDao.create(user1);
//
//        User user2 = new User();
//        user2.setUsername("Janek13");
//        user2.setEmail("janek13@poczta.pl");
//        user2.setPassword("dkhfHYR%$39tRU");
//        userDao1.create(user2);

//        User user2 = userDao.read(4);
//        System.out.println(user2.toString());
//        user2.setEmail("kolo222@zmail.net");
//        user2.setUsername("Kolo222");
//        user2.setPassword("idehKHiKjdo87668(*&^%");
//        System.out.println(user2.getPassword());
//        userDao.update(user2);
//        user2 = userDao.read(4);
//        System.out.println(user2.toString());
//        userDao.delete(4);
//        for (User user : userDao.findAll()) {
//            System.out.println(user.toString());
//        }


    }
}
