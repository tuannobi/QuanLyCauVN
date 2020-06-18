package com.quanlycauvn.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ThongTinNhanVien")
public class ThongTinNhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaThongTin")
    private Integer maThongTin;

    @Column(name="HoTen")
    private String hoTen;

    @Column(name="NgaySinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;

    @Column(name="DiaChi")
    private String diaChi;

    @Column(name="SDT")
    private String SDT;

    @Column(name="email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;

    public ThongTinNhanVien() {
    }

    public ThongTinNhanVien(String hoTen, Date ngaySinh, String diaChi, String SDT, String email, User user) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.SDT = SDT;
        this.email = email;
        this.user = user;
    }

    public Integer getMaThongTin() {
        return maThongTin;
    }

    public void setMaThongTin(Integer maThongTin) {
        this.maThongTin = maThongTin;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
