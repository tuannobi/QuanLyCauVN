package com.quanlycauvn.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ChuDauTu")
public class ChuDauTu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaChuDauTu")
    private Integer maChuDauTu;

    @Column(name = "TenChuDauTu")
    private String tenChuDauTu;

    @Column(name="NgaySinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;

    @Column(name="DiaChi")
    private String diaChi;

    @Column(name="SDT")
    private String SDT;

    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "chuDauTu")
    private List<Cau> caus;

    public ChuDauTu() {
    }

    public ChuDauTu(Integer maChuDauTu) {
        this.maChuDauTu = maChuDauTu;
    }

    public Integer getMaChuDauTu() {
        return maChuDauTu;
    }

    public void setMaChuDauTu(Integer maChuDauTu) {
        this.maChuDauTu = maChuDauTu;
    }

    public String getTenChuDauTu() {
        return tenChuDauTu;
    }

    public void setTenChuDauTu(String tenChuDauTu) {
        this.tenChuDauTu = tenChuDauTu;
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

    public List<Cau> getCaus() {
        return caus;
    }

    public void setCaus(List<Cau> caus) {
        this.caus = caus;
    }
}
