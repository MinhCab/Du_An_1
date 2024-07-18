/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author Admin
 */
public class Respository {
    public String getRole(String username, String password){
        String sql = "select role \n" +
                    "	  from Users\n" +
                    "	  where username = ? and password = ?";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            String role = "NO";
            while(rs.next()){
                role = rs.getString("role");
            }
            return role;
        } catch (Exception e) {
        }
        return "NO";
    }
    
    public static void main(String[] args) {
        Respository repo = new Respository();
        System.out.println(repo.getRole("nhanvien", "nhanvien123"));
    }
}
