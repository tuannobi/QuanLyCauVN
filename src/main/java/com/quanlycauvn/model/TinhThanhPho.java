package com.quanlycauvn.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TinhThanhPho")
public class TinhThanhPho {
    @Id
    @Column(name = "matp")
    private String matp;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "tinhThanhPho")
    private List<Cau> caus;

    @OneToMany(mappedBy = "tinhThanhPho")
    private List<QuanHuyen> quanHuyens;

    public TinhThanhPho() {
    }

    public TinhThanhPho(String matp) {
        this.matp = matp;
    }

    public String getMatp() {
        return matp;
    }

    public void setMatp(String matp) {
        this.matp = matp;
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

    public List<QuanHuyen> getQuanHuyens() {
        return quanHuyens;
    }

    public void setQuanHuyens(List<QuanHuyen> quanHuyens) {
        this.quanHuyens = quanHuyens;
    }


}
