package com.quanlycauvn.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Integer userId;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @ManyToOne
    @JoinColumn(name="MaVaiTro")
    private VaiTro vaiTro;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private ThongTinNhanVien thongTinNhanVien;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private DRVN drvn;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private SoGTVT soGTVT;

    @OneToMany(mappedBy = "user")
    private  List<Cau> caus;

    public Integer getUserId() {
        return userId;
    }

    public User() {
    }

    public DRVN getDrvn() {
        return drvn;
    }

    public void setDrvn(DRVN drvn) {
        this.drvn = drvn;
    }

    public SoGTVT getSoGTVT() {
        return soGTVT;
    }

    public void setSoGTVT(SoGTVT soGTVT) {
        this.soGTVT = soGTVT;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public VaiTro getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(VaiTro vaiTro) {
        this.vaiTro = vaiTro;
    }

    public ThongTinNhanVien getThongTinNhanVien() {
        return thongTinNhanVien;
    }

    public void setThongTinNhanVien(ThongTinNhanVien thongTinNhanVien) {
        this.thongTinNhanVien = thongTinNhanVien;
    }

    public List<Cau> getCaus() {
        return caus;
    }

    public void setCaus(List<Cau> caus) {
        this.caus = caus;
    }


}
