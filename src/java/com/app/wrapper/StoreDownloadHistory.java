
package com.app.wrapper;

import com.app.utility.DBConnectionn;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author Puja
 */
public class StoreDownloadHistory {

    
    public static void storeDownloads(int id, String ownername,String fileName, String key, String initVector) {
        PreparedStatement ps = null;
        try(Connection con = DBConnectionn.getConnection()) {
            Date cdate = new Date(new java.util.Date().getTime());
            String sqlQuery = "insert into downloads(fileid,ownername,filename,privatekey,publickey,downloaddate) values(?,?,?,?,?,?)";
            ps = con.prepareStatement(sqlQuery);
            ps.setInt(1, id);
            ps.setString(2, ownername);
            ps.setString(3, fileName);
            ps.setString(4, key);
            ps.setString(5, initVector);
            ps.setDate(6, cdate);
            ps.executeUpdate();
            
            
        } catch (Exception e) {
            System.out.println("Error at Downloads "+e.getMessage());
        }
    }
    
}
