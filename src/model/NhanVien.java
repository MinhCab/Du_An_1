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
    private LoaiUser loaiUser;
    private String matKhau;
    
    public NhanVien(String ma, String ten, String sdt, int gioiTinh, String diaChi, LoaiUser loaiUser, String matKhau) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.loaiUser = loaiUser;
        this.matKhau = matKhau;
    }

    public NhanVien() {
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
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public LoaiUser getLoaiUser() {
        return loaiUser;
    }

    public void setLoaiUser(LoaiUser loaiUser) {
        this.loaiUser = loaiUser;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + diaChi + " " + loaiUser.getMa_loai() + " " + loaiUser.getTen();
    }
    
    
    public Object[] toRowTable() {
        return new Object[]{
            ma,ten,sdt,gioiTinh == 1 ? "Nam":"Nữ",loaiUser.getTen(), diaChi
        };
    }
}