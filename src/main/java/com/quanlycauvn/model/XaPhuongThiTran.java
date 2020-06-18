package com.quanlycauvn.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "XaPhuongThiTran")
public class XaPhuongThiTran {
    @Id
    @Column(name = "xaid")
    private String xaId;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "xaPhuongThiTran")
    private List<Cau> caus;

    @ManyToOne
    @JoinColumn(name = "maqh")
    private QuanHuyen quanHuyen;

    public XaPhuongThiTran() {
    }

    public XaPhuongThiTran(String xaId) {
        this.xaId = xaId;
    }


    public String getXaId() {
        return xaId;
    }

    public void setXaId(String xaId) {
        this.xaId = xaId;
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

    public QuanHuyen getQuanHuyen() {
        return quanHuyen;
    }

    public void setQuanHuyen(QuanHuyen quanHuyen) {
        this.quanHuyen = quanHuyen;
    }


}
