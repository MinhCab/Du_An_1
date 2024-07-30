/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class user {
    private String ma_user, ten, dia_chi;
    private int sdt;
    private boolean gioiTinh;
    private LoaiUser loaiUser;

    public user() {
    }

    public user(String ma_user, String ten, String dia_chi, int sdt, boolean gioiTinh, LoaiUser loaiUser) {
        this.ma_user = ma_user;
        this.ten = ten;
        this.dia_chi = dia_chi;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.loaiUser = loaiUser;
    }

    public String getMa_user() {
        return ma_user;
    }

    public void setMa_user(String ma_user) {
        this.ma_user = ma_user;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public LoaiUser getLoaiUser() {
        return loaiUser;
    }

    public void setLoaiUser(LoaiUser loaiUser) {
        this.loaiUser = loaiUser;
    }
}
