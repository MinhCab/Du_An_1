/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;
import JDBC.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.LoaiUser;
import model.User;


/**
 *
 * @author Admin
 */
public class LoginFunction {
    public String Login(String username, String password){
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
            User user = new User();
            String ma_user 
            while(rs.next()){
                
                User user = new User(rs.getString("ma_user"), rs.getString("ten"), rs.getString("dia_chi"), 
                        rs.getInt("sdt"), rs.getBoolean("gioitinh"), new LoaiUser().setMa_loai("loai_user"));
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
