package com.bwei.haohao.controller;

import com.bwei.haohao.bean.Food;
import com.bwei.haohao.bean.FoodType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("foodC")
public class FoodController {

    @Resource
    private RestTemplate restTemplate;

    /**
     * 增加或者删除
     * @param food
     * @param tid
     * @return
     */
    @RequestMapping("InsertOrUpdateC")
    public boolean InsertOrUpdate(Food food,Integer tid){

        System.out.println(food.getCreateDate()+"----------------------------------");

        //定义一个路径
        String url = "";
        if(food.getFid()==null||food.getFid()==0){
            url="http://localhost:8088/server/InsertOrUpdate?tid="+tid;
        }else{
            url="http://localhost:8088/server/InsertOrUpdate";
        }
        Boolean post = restTemplate.postForObject(url, food, boolean.class);
        return post;
    }

    @RequestMapping("deleteC")
    public boolean deleteC(Integer fids[]){

        return restTemplate.postForObject("http://localhost:8088/server/delete",fids,boolean.class);
    }

    /**
     * 获取第二张表
     * @return
     */
    @RequestMapping("getTypes")
    public List<FoodType> getTypes(){
        List list = restTemplate.getForObject("http://localhost:8088/server/getFoodType", List.class);
        return list;
    }
}
