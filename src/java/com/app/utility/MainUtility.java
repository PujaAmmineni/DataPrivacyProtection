
package com.app.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Puja
 */
public class MainUtility {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public String getRequestSecretKeyStatus(String clientName,String ownername,String fileName){
    String status = "nodata";
        try {
            con = DBConnectionn.getConnection();
            String sqlQuery = "select secretkeystatus from requestsecretkey where username = ? and owner = ? and filename = ?";
            ps = con.prepareStatement(sqlQuery);
            ps.setString(1, clientName);
            ps.setString(2, ownername);
            ps.setString(3, fileName);
            rs = ps.executeQuery();
            while(rs.next()){
            status = rs.getString("secretkeystatus");
            }
            
        } catch (Exception e) {
            System.out.println("Error at getRequestSecretKeyStatus = "+e.getMessage());
        }finally{
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }
    return status;
    }
    
    public String getRequestDecryptKeyStatus(String clientName,String ownername,String fileName){
    String status = "nodata";
        try {
            con = DBConnectionn.getConnection();
            String sqlQuery = "select decreptkeystatus from requestdecryptkey where username = ? and owner = ? and filename = ?";
            ps = con.prepareStatement(sqlQuery);
            ps.setString(1, clientName);
            ps.setString(2, ownername);
            ps.setString(3, fileName);
            rs = ps.executeQuery();
            while(rs.next()){
            status = rs.getString("decreptkeystatus");
            }
            
        } catch (Exception e) {
            System.out.println("Error at getRequestSecretKeyStatus = "+e.getMessage());
        }finally{
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
            }
        }
    return status;
    }
public int getFileRank(int fileid){
    int rank = 0;
    try {
        con = DBConnectionn.getConnection();
        String sqlquery = "select rank from datafiles where id=?";
        ps = con.prepareStatement(sqlquery);
        ps.setInt(1,fileid);
        rs = ps.executeQuery();
        rs.next();
        rank = rs.getInt("rank");
        rank++;
    } catch (Exception e) {
        System.out.println("Error at Getting Rank"+e.getMessage());
    }finally{
        try {
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
        }
    }
    return rank;
}

 public void updateFileRank(int fileid){
    int rank = getFileRank(fileid);
    try {
        con = DBConnectionn.getConnection();
        String sqlquery = "update datafiles set rank = ? where id = ?";
        ps = con.prepareStatement(sqlquery);
        ps.setInt(1,rank);
        ps.setInt(2, fileid);
        ps.executeUpdate();
        
    } catch (Exception e) {
        System.out.println("Error at Getting Rank"+e.getMessage());
    }finally{
        try {
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
        }
    }
   
}

}