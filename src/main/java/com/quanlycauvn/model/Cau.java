package com.quanlycauvn.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Cau")
public class Cau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SoThuTu")
    private Integer soThuTu;

    @Column(name = "TenCau")
    private String tenCau;

    @Column(name = "TongMucDauTu")
    private float tongMucDauTu;

    @Column(name = "NamXayDung")
    private int NamXayDung;

    @Column(name = "NamHoanThanh")
    private int NamHoanThanh;

    @Column(name = "NamDuaVaoKhaiThac")
    private int namDuaVaoKhaiThac;

    @Column(name="NgayTao")
    @Temporal(TemporalType.DATE)
    private Date ngayTao;

    @Column(name="NgayCapNhat")
    @Temporal(TemporalType.DATE)
    private Date ngayCapNhat;

    @Column(name = "TaiTrongThietKe")
    private String taiTrongThietKe;

    @Column(name="DonViThietKe")
    private String donViThietKe;

    @Column(name = "DonViThiCong")
    private String donViThiCong;

    @Column(name="DonViGiamSat")
    private String donViGiamSat;

    @Column(name="DonViQuanLy")
    private String donViQuanLy;

    @Column(name="QuocLo")
    private String quocLo;

    @Column(name="TinhTrangCau")
    private String tinhTrangCau;

    @ManyToOne
    @JoinColumn(name = "MaChuDauTu")
    private ChuDauTu chuDauTu;

    @ManyToOne
    @JoinColumn(name="UserId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "xaPhuongThiTranId")
    private XaPhuongThiTran xaPhuongThiTran;

    @ManyToOne
    @JoinColumn(name = "QuanHuyenId")
    private QuanHuyen quanHuyen;

    @ManyToOne
    @JoinColumn(name = "TinhThanhPhoId")
    private TinhThanhPho tinhThanhPho;

    public Integer getSoThuTu() {
        return soThuTu;
    }

    public void setSoThuTu(Integer soThuTu) {
        this.soThuTu = soThuTu;
    }

    public String getTenCau() {
        return tenCau;
    }

    public void setTenCau(String tenCau) {
        this.tenCau = tenCau;
    }

    public float getTongMucDauTu() {
        return tongMucDauTu;
    }

    public void setTongMucDauTu(float tongMucDauTu) {
        this.tongMucDauTu = tongMucDauTu;
    }

    public int getNamXayDung() {
        return NamXayDung;
    }

    public void setNamXayDung(int namXayDung) {
        NamXayDung = namXayDung;
    }

    public int getNamHoanThanh() {
        return NamHoanThanh;
    }

    public void setNamHoanThanh(int namHoanThanh) {
        NamHoanThanh = namHoanThanh;
    }

    public int getNamDuaVaoKhaiThac() {
        return namDuaVaoKhaiThac;
    }

    public void setNamDuaVaoKhaiThac(int namDuaVaoKhaiThac) {
        this.namDuaVaoKhaiThac = namDuaVaoKhaiThac;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    public String getTaiTrongThietKe() {
        return taiTrongThietKe;
    }

    public void setTaiTrongThietKe(String taiTrongThietKe) {
        this.taiTrongThietKe = taiTrongThietKe;
    }

    public String getDonViThietKe() {
        return donViThietKe;
    }

    public void setDonViThietKe(String donViThietKe) {
        this.donViThietKe = donViThietKe;
    }

    public String getDonViThiCong() {
        return donViThiCong;
    }

    public void setDonViThiCong(String donViThiCong) {
        this.donViThiCong = donViThiCong;
    }

    public String getDonViGiamSat() {
        return donViGiamSat;
    }

    public void setDonViGiamSat(String donViGiamSat) {
        this.donViGiamSat = donViGiamSat;
    }

    public String getDonViQuanLy() {
        return donViQuanLy;
    }

    public void setDonViQuanLy(String donViQuanLy) {
        this.donViQuanLy = donViQuanLy;
    }

    public String getQuocLo() {
        return quocLo;
    }

    public void setQuocLo(String quocLo) {
        this.quocLo = quocLo;
    }

    public String getTinhTrangCau() {
        return tinhTrangCau;
    }

    public void setTinhTrangCau(String tinhTrangCau) {
        this.tinhTrangCau = tinhTrangCau;
    }

    public ChuDauTu getChuDauTu() {
        return chuDauTu;
    }

    public void setChuDauTu(ChuDauTu chuDauTu) {
        this.chuDauTu = chuDauTu;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public XaPhuongThiTran getXaPhuongThiTran() {
        return xaPhuongThiTran;
    }

    public void setXaPhuongThiTran(XaPhuongThiTran xaPhuongThiTran) {
        this.xaPhuongThiTran = xaPhuongThiTran;
    }

    public QuanHuyen getQuanHuyen() {
        return quanHuyen;
    }

    public void setQuanHuyen(QuanHuyen quanHuyen) {
        this.quanHuyen = quanHuyen;
    }


    public TinhThanhPho getTinhThanhPho() {
        return tinhThanhPho;
    }

    public void setTinhThanhPho(TinhThanhPho tinhThanhPho) {
        this.tinhThanhPho = tinhThanhPho;
    }


}
