package com.quanlycauvn.model;

import javax.persistence.*;

@Entity
@Table(name="SoGTVT")
public class SoGTVT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaSoGTVT")
    private Integer maSoGTVT;

    @Column(name="Ten")
    private String ten;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;

    public Integer getMaSoGTVT() {
        return maSoGTVT;
    }

    public void setMaSoGTVT(Integer maSoGTVT) {
        this.maSoGTVT = maSoGTVT;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
