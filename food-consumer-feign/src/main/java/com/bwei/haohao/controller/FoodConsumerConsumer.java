package com.bwei.haohao.controller;

import com.bwei.haohao.bean.Food;
import com.bwei.haohao.bean.FoodType;
import com.bwei.haohao.feign.FoodFeigenInterface;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("foodCf")
@CrossOrigin
public class FoodConsumerConsumer {

    @Resource
    private FoodFeigenInterface feigenInterface;


    /**
     * 增加
     * @param food
     * @param tid
     * @return
     */
    @RequestMapping("InsertOrUpdate")
    public boolean InsertOrUpdate(Food food,Integer tid){
        boolean b = feigenInterface.InsertOrUpdate(food, tid);
        return b;
    }

    /**
     * 批量删除
     * @param fids
     * @return
     */
    @RequestMapping("deleteAll")
    public boolean deleteAll(Integer []fids){
        boolean b = feigenInterface.delete(fids);
        return b;
    }

    /**
     * 获取全部的属性
     * @return
     */
    @RequestMapping("getType")
    public List<FoodType> getType(){
        return feigenInterface.getType();
    }
}
