package AirlineManagementSystem;

import java.sql.*;

//creating connection with database
public class Conn {
    Connection c;
    Statement s;
    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///airline","root","aanchal");
            s = c.createStatement();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}