/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class NhanVien {
    private String ma;
    private String ten;
    private String sdt;
    private int gioiTinh;
    private String diaChi;
    private int loai;
    private String matKhau;
    
    public NhanVien(String ma, String ten, String sdt, int gioiTinh, String diaChi, int loai, String matKhau) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.loai = loai;
        this.matKhau = matKhau;
    }

    public NhanVien() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String getMa() {
        return ma;
    }
    
    public void setMa(String ma) {
        this.ma = ma;
    }
    
    public String getTen() {
        return ten;
    }
    
    public void setTen(String ten) {
        this.ten = ten;
    }
    
    
    public String getSdt() {
        return sdt;
    }
    
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
    public int getGioiTinh() {
        return gioiTinh;
    }
    
    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
    public String getDiaChi() {
        return ma;
    }
    
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    public int getloai() {
        return loai;
    }
    
    public void setloai(int loai) {
        this.loai = loai;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    
    public Object[] toRowTable() {
        return new Object[]{
            ma,ten,sdt,gioiTinh == 1 ? "Nam":"Nữ",diaChi,loai == 1 ? "Nhân viên bán hàng":"Nhân viên kho",matKhau
        };
    }
}
