/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;
import JDBC.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.user;
import model.NhanVien;

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
    //Quan ly nhan vien
    
    
    public List<NhanVien> getAll(){
        String sql = """
                     select ma_user, ten,dia_chi,sdt,gioitinh,loai_user,mat_khau from Users
                     """;
        List<NhanVien> list = new ArrayList<>();
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                NhanVien nv = new NhanVien();
                nv.setMa(rs.getString("ma"));
                nv.setTen(rs.getString("ten"));
                nv.setSdt(rs.getString("sdt"));
                nv.setGioiTinh(rs.getInt("gioitinh"));
                nv.setDiaChi(rs.getString("diachi"));
                nv.setloai(rs.getInt("LoaiUser"));
                nv.setMatKhau(rs.getString("matKhau"));
                list.add(nv);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public int xoaNhanVien(NhanVien nv){
        String sql = """
                     delete from Users
                     where ma_user = ?
                     """;
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getMa());
            ps.setString(2, nv.getTen());
            ps.setString(3, nv.getSdt());
            ps.setInt(4, nv.getGioiTinh());
            ps.setString(5, nv.getDiaChi());
            ps.setInt(6, nv.getloai());
            ps.setString(7, nv.getMatKhau());
            int x = ps.executeUpdate();
            return x;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    
    public int suaSinhVien(NhanVien nv){
        String sql = """
                     update Users
                     set ma_user = ?,ten = ?,dia_chi = ?,sdt = ?,gioitinh = ?,loai_user = ?,mat_khau = ?
                     where ma_user = ?
                     """;
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getTen());
            int x = ps.executeUpdate();
            return x;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static void main(String[] args) {
        LoginFunction repo = new LoginFunction();
        System.out.println(repo.Login("admin", "123456"));
    }
}