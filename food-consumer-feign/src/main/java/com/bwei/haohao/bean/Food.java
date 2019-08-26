package com.bwei.haohao.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Food implements Serializable {

    private Integer fid;

    private String fname;

    private String fmag;

    private Date createDate;

    private FoodType foodType;

}
