/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;
import JDBC.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;

public class LoginFunction {

    public String Login(String username, String password) {
        String sql = "SELECT loai_user FROM Users WHERE ma_user = ? AND mat_khau = ?";
        String role = "NO";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    role = rs.getString("loai_user");
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
        }

        return role;
    }

    public static void main(String[] args) {
        LoginFunction repo = new LoginFunction();
        System.out.println(repo.Login("admin", "123456"));
    }
}