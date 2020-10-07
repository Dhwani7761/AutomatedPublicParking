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
public class CancelBusinessLogic {
  Connection con = null;
   Statement st = null;
   PreparedStatement ps = null;
   ResultSet rs= null;
   String conString = "jdbc:derby://localhost:1527/db2";
   String db = "org.apache.derby.jdbc.ClientDriver";
   
    public CancelBusinessLogic() {
        try
        {
            Class.forName(db);
            con=DriverManager.getConnection(conString,"db2","db2");
        }catch(Exception r)
        {
            System.out.println(r);
        }
    }
    public boolean Cancel(String token)
    {
        boolean flag = false;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/db2","db2","db2");
            String sql = "Delete from booking where Token = " + token;
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate();
        }catch(Exception e)
        {
            System.out.println(e);
        }
            
      return flag;
    }
    
}
