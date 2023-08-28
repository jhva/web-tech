import day1.User;
import day1.UserDao;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UserDao dao = new UserDao();

        User user = new User();

        user.setId("test@");
        user.setName("김정훈");
        user.setPassword("testpassword");

        dao.add(user);

        System.out.println("등록성공");


    }
}