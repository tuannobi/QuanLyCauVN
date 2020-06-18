package com.quanlycauvn.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "QuanHuyen")
public class QuanHuyen {
    @Id
    @Column(name = "maqh")
    private String maqh;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "quanHuyen")
    private List<Cau> caus;

    @OneToMany(mappedBy = "quanHuyen")
    private List<XaPhuongThiTran> xaPhuongThiTrans;

    @ManyToOne
    @JoinColumn(name = "matp")
    private TinhThanhPho tinhThanhPho;

    public QuanHuyen() {
    }

    public QuanHuyen(String maqh) {
        this.maqh = maqh;
    }

    public String getMaqh() {
        return maqh;
    }

    public void setMaqh(String maqh) {
        this.maqh = maqh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Cau> getCaus() {
        return caus;
    }

    public void setCaus(List<Cau> caus) {
        this.caus = caus;
    }

    public List<XaPhuongThiTran> getXaPhuongThiTrans() {
        return xaPhuongThiTrans;
    }

    public void setXaPhuongThiTrans(List<XaPhuongThiTran> xaPhuongThiTrans) {
        this.xaPhuongThiTrans = xaPhuongThiTrans;
    }

    public TinhThanhPho getTinhThanhPho() {
        return tinhThanhPho;
    }

    public void setTinhThanhPho(TinhThanhPho tinhThanhPho) {
        this.tinhThanhPho = tinhThanhPho;
    }


}
