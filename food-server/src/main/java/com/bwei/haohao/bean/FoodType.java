package com.bwei.haohao.bean;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_foodtype")
public class FoodType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    @Column(name = "tname",length = 30)
    private String tname;
}
