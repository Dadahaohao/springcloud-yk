package com.bwei.haohao.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_food")
@Data
public class Food implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fid;

    @Column(name = "fname",length = 30)
    private String fname;

    @Column(name = "fmg",length = 20,nullable = false)
    private String fmag;

    @Column(name = "createDate",nullable = false)
    private Date createDate;

    @ManyToOne(optional = false,cascade = {CascadeType.MERGE,CascadeType.DETACH})
    @JoinColumn(name = "tid")
    private FoodType foodType;

}
