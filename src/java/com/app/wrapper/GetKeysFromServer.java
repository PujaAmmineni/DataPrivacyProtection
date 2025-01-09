
package com.app.wrapper;

import com.app.utility.DBConnectionn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Puja
 */
public class GetKeysFromServer {
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public String getPrivateKey(int id){
    String privatekey = null;
        try(Connection con = DBConnectionn.getConnection();) {
            String sqlQuery = "select privatekey from datafiles where id = ?";
            ps = con.prepareStatement(sqlQuery);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            privatekey = rs.getString("privatekey");            
        } catch (Exception e) {
            System.out.println("Error at Private Key "+e.getMessage());
        }
    return privatekey;
    }
    
    public String getPublicKey(int id){
    String publickey = null;
        try(Connection con = DBConnectionn.getConnection()) {
            String sqlQuery = "select publickey from datafiles where id = ?";
            ps = con.prepareStatement(sqlQuery);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            publickey = rs.getString("publickey");            
        } catch (Exception e) {
            System.out.println("Error at publickey Key "+e.getMessage());
        }
    return publickey;
    }
    
}
