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
import model.LoaiUser;
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
                     SELECT t1.ma_user, t1.ten, t1.sdt, t1.dia_chi, t1.gioitinh, t1.loai_user, t2.ten as tenLoai FROM Users as t1, LoaiUser as t2 WHERE t1.loai_user = t2.ma_loai
                     """;
        List<NhanVien> list = new ArrayList<>();
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                NhanVien nv = new NhanVien();
                nv.setMa(rs.getString("ma_user"));
                nv.setTen(rs.getString("ten"));
                nv.setSdt(rs.getString("sdt"));
                nv.setGioiTinh(rs.getInt("gioitinh"));
                nv.setDiaChi(rs.getString("dia_chi"));
                nv.setLoaiUser(new LoaiUser(rs.getString("loai_user"), rs.getString("tenLoai")));
                list.add(nv);
                System.out.println(nv.toString());
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public int themNhanVien(NhanVien nv){
        String sql = """
                     insert into Users(t1.ma_user, t1.ten, t1.sdt, t1.dia_chi, t1.gioitinh)
                     values(?,?,?,?,?,?,?)
                     """;
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getMa());
            ps.setString(2, nv.getTen());
            ps.setString(3, nv.getSdt());
            ps.setString(4, nv.getDiaChi());
            ps.setInt(5, nv.getGioiTinh());
            return x;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
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
            ps.setString(6, nv.getMatKhau());
            ResultSet rs = ps.executeQuery();  // Assuming you are executing a query
            if (rs.next()) {
                 nv.setLoaiUser(new LoaiUser(rs.getString("loai_user"), rs.getString("tenLoai")));
    }
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