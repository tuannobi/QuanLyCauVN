package com.quanlycauvn.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="VaiTro")
public class VaiTro {
    @Id
    @Column(name = "MaVaiTro")
    private Integer maVaiTro;

    @Column(name="LoaiVaiTro")
    private String loaiVaiTro;

    @Column(name="moTa")
    private String moTa;

    @OneToMany(mappedBy = "vaiTro")
    private List<User> users;

    public VaiTro() {
    }

    public VaiTro(Integer maVaiTro) {
        this.maVaiTro = maVaiTro;
    }

    public VaiTro(int maVaiTro, String loaiVaiTro, String moTa){
        this.maVaiTro=maVaiTro;
        this.loaiVaiTro=loaiVaiTro;
        this.moTa=moTa;
    }

    public Integer getMaVaiTro() {
        return maVaiTro;
    }

    public void setMaVaiTro(Integer maVaiTro) {
        this.maVaiTro = maVaiTro;
    }

    public String getLoaiVaiTro() {
        return loaiVaiTro;
    }

    public void setLoaiVaiTro(String loaiVaiTro) {
        this.loaiVaiTro = loaiVaiTro;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "VaiTro{" +
                "maVaiTro=" + maVaiTro +
                ", loaiVaiTro='" + loaiVaiTro + '\'' +
                ", moTa='" + moTa + '\'' +
                ", users=" + users +
                '}';
    }
}
