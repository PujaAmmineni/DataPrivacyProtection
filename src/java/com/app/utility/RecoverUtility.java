
package com.app.utility;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Puja
 */
public class RecoverUtility {
    
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void getNotAttackedData(int fileid) {
        String originaldata = null;
        try {
            con = DBConnectionn.getConnection();
            String sqlQu = "select contenets from attackersdata where fileid = ?";
            ps = con.prepareStatement(sqlQu);
            ps.setInt(1, fileid);
            rs = ps.executeQuery();
            if (rs.next()) {
                originaldata = rs.getString("contents");
                setDataRecovering(fileid,  originaldata);
            }
        } catch (Exception e) {
            System.out.println("Error at Getting Data " + e.getMessage());
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }
    }

    public void setDataRecovering(int fileid, String contents) {      
        try {           
            con = DBConnectionn.getConnection();
            String sqlQu = "update datafiles set contents = ? where id = ?";
            ps = con.prepareStatement(sqlQu);
            ps.setString(1, contents);
            ps.setInt(2, fileid);           
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error at Updating Data " + e.getMessage());
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }
    }
    public void updateFileStatus(int fileid){
     String status = "safe";
        try {
            con = DBConnectionn.getConnection();
            String sqlQu = "update datafiles set attackstatus = ? where id = ?";
            ps = con.prepareStatement(sqlQu);
            ps.setString(1, status);
            //ps.setString(2, contents);
            ps.setInt(2, fileid);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error at Status done Data " + e.getMessage());
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }
    }
      public void deleteAttackedData(int fileid) {      
        try {           
            con = DBConnectionn.getConnection();
            String sqlQu = "delete from  attackersdata where fileid = ?";
            ps = con.prepareStatement(sqlQu);            
            ps.setInt(1, fileid);           
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error at Updating Data " + e.getMessage());
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }
    }
}
