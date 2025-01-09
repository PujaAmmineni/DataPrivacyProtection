
package com.app.utility;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Puja
 */
public class Attackerutility {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void getPlainDataandStoreInANotherTable(int fileid, String fileName) {
        String originaldata = null;
        try {
            con = DBConnectionn.getConnection();
            String sqlQu = "select cipherdata from datafiles where id = ?";
            ps = con.prepareStatement(sqlQu);
            ps.setInt(1, fileid);
            rs = ps.executeQuery();
            if (rs.next()) {
                originaldata = rs.getString("cipherdata");
                setData(fileid, fileName, originaldata);
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

    public void setData(int fileid, String filename, String content) {
        java.sql.Date cdate = new java.sql.Date(new java.util.Date().getTime());
        String hostname = "Unknown";

        try {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
            String ip = addr.getHostAddress();
            System.out.println("Host Name " + hostname);
            String os = System.getProperty("os.name");
            System.out.println("OS Name " + os);
            con = DBConnectionn.getConnection();
            String sqlQu = "insert into attackersdata(filename,fileid,cdate,ipaddress,osname,systemname) values(?,?,?,?,?,?)";
            ps = con.prepareStatement(sqlQu);
            ps.setString(1, filename);
            ps.setInt(2, fileid);
            
            ps.setDate(3, cdate);
            ps.setString(4, ip);
            ps.setString(5, os);
            ps.setString(6, hostname);
            ps.executeUpdate();
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
    public void updateFileStatus(int fileid,String contents){
     String status = "Attacked";
        try {
            con = DBConnectionn.getConnection();
            String sqlQu = "update datafiles   where id = ?";
            ps = con.prepareStatement(sqlQu);
           
            ps.setInt(1, fileid);
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
}
