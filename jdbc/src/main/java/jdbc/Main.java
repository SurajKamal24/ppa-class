package jdbc;

import org.postgresql.Driver;

import java.sql.*;

public class Main {
    // certain format
    //"jdbc:mysql://localhost:3306/suraj ", "root", "roor"
    //"jdbc:postgresql://localhost:5432/postgres", "root", "root"
    public static void main(String[] args) throws SQLException {
        func("jdbc:mysql://localhost:3306/suraj", "root", "root");
    }

    public static void func(String url, String user, String pwd) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, pwd);
        Statement s1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        // statement <==assoc==> 1 res set only
        ResultSet rs1 = s1.executeQuery("select * from products where name='Kindle'");
        while (rs1.next()) {
            System.out.println(rs1.getInt("id"));
        }
        while (rs1.previous()) {
            System.out.println(rs1.getInt("id"));
        }
        System.out.println(rs1.first());
        System.out.println(rs1.getInt("id"));
        System.out.println(rs1.last());
        System.out.println(rs1.getInt("id"));
        System.out.println(rs1.absolute(1));
        System.out.println(rs1.getInt("id"));
        System.out.println(rs1.absolute(-1));
        System.out.println(rs1.getInt("id"));
    }

    public static void infinte() throws SQLException {
        while (true) {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/suraj", "root", "root");
                Statement statement = connection.createStatement();
                statement.executeQuery("select * from products");
            } finally {
                if (connection != null)
                    connection.close();
            }
        }
    }

    public static void connectToDB(String url, String user, String pwd, String table) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, pwd);
        Statement statement = conn.createStatement();
        //ResultSet rs = statement.executeQuery("select * from " + table);
        /*while (rs.next()) {
            System.out.println(rs.getString("id"));
        }*/
        int cnt = statement.executeUpdate("update " + table + " set full_version = 100.0 where name='JBL'");
        System.out.println(cnt);
    }
}

// App ---Query---> (r1r2r3r4r5r6r7r8......)DB(started executing, creating results)
// physical resources are init at DB side
// data : hard drive
// object : RAM

// cursor: R1: Hasmap id:1 | name:Kindle | desc:reader | ver:1.190
// R2
// R3
// diff dialects
// JDBC, won't have to learn SQL?
// products(id,.....) | feedbacks(pid, uid, review)
// 1, Apple     1, good
// 2 Kindle     2, costly
// 3 iMac       3, ....