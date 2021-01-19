package onlinelibrary.data;

import java.sql.*;
import onlinelibrary.business.Student;

public class StudentDB {

    public static int insert(Student user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        

        String query = "INSERT INTO Student (studentid, firstname, lastname, username, email, password,salt) "
                + "VALUES (?, ?, ?, ?, ?, ?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getSid());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getUsername());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPassword());
            ps.setString(7,user.getSalt());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    }