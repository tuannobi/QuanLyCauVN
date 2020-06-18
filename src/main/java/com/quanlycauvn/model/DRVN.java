package com.quanlycauvn.model;

import javax.persistence.*;

@Entity
@Table(name="DRVN")
public class DRVN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDRVN")
    private Integer maDRVN;

    @Column(name="Ten")
    private String ten;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;

    public Integer getMaDRVN() {
        return maDRVN;
    }

    public void setMaDRVN(Integer maDRVN) {
        this.maDRVN = maDRVN;
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
