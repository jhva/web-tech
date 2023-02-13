package day1;

import javax.xml.transform.Result;
import java.sql.*;

/**
 * 중복성 ?
 * 관심사 분리
 * 클래스 분리 (리팩토링)
 * 인테페이스 도입
 *
 */
public class UserDao {
    private SimpleConnectionMaker simpleConnectionMaker; //클래스분리

    public UserDao() {
        simpleConnectionMaker = new SimpleConnectionMaker();
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        // 중복성 코드를 하나의 단일 메소드로 뺀후 추출

//        Connection con = getConnection();
        Connection con = simpleConnectionMaker.makerCon();

        PreparedStatement ps = con.prepareStatement("insert into users(id,name,password) values (?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();

        con.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/practiceSpringData");

        // 중복성 코드를 하나의 단일 메소드로 뺀후 추출

//        Connection con = getConnection();
        Connection con = simpleConnectionMaker.makerCon();

        PreparedStatement ps = con.prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();

        ps.close();

        con.close();
        return user;
    }

    // 중복된 코드를 독립적인 메소드를 만들자 (2)
//    private Connection getConnection() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/practiceSpringData");
//
//        return con;
//    }

    // 추상클래스로 만든 커넥션   (3) -> (4) 추상클래스인 connection을 상속받아서 어떨댄 mariadb, 어떨댄 mysql이렇게 나눌수가있게됨
//    public abstract Connection getConnection () throws ClassNotFoundException,SQLException;

}
