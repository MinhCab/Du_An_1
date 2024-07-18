/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;
import JDBC.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author Admin
 */
public class LoginFunction {
    public String getRole(String username, String password){
        String sql = "select loai_user \n" +
                    "	  from Users\n" +
                    "	  where ma_user = ? and mat_khau = ?";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            String role = "NO";
            while(rs.next()){
                role = rs.getString("loai_user");
            }
            return role;
        } catch (Exception e) {
        }
        return "NO";
    }
    
    public static void main(String[] args) {
        LoginFunction repo = new LoginFunction();
        System.out.println(repo.getRole("admin", "123456"));
    }
}
