/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatedparkingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Dhwani
 */
class BookingBusinessLogic {

    Connection con = null;
    Statement st = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String conString = "jdbc:derby://localhost:1527/db2";
    String db = "org.apache.derby.jdbc.ClientDriver";

    public BookingBusinessLogic() {
        try {
            Class.forName(db);
            con = DriverManager.getConnection(conString, "db2", "db2");
        } catch (Exception r) {
            System.out.println(r);
        }
    }

    public boolean addEmployee(String area, java.util.Date dt, String from, String to, String vno, int token, String vtype) {
        boolean flag = false;

        try {

            ps = con.prepareStatement("Insert into Booking values(?,?,?,?,?,?,?)");
            ps.setString(1, area);
            java.sql.Date sqlDate = new java.sql.Date(dt.getTime());
            ps.setDate(2, sqlDate);
            ps.setString(3, from);
            ps.setString(4, to);
            ps.setString(5, vno);
            ps.setInt(6, token);
            ps.setString(7, vtype);
            int i = ps.executeUpdate();
            if (i == 1) {
                flag = true;
            }
            System.out.println(i);
        } catch (Exception e) {
            System.out.println(e);
        }
        return flag;
    }
}
