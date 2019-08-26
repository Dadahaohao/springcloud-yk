package com.bwei.haohao.feign;

import com.bwei.haohao.bean.Food;
import com.bwei.haohao.bean.FoodType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "food-server")
@Component
public interface FoodFeigenInterface {

    @RequestMapping("server/InsertOrUpdate")
    boolean InsertOrUpdate(@RequestBody Food food, @RequestParam(name = "tid") Integer tid);

    @RequestMapping("delete")
    boolean delete(Integer fids[]);

    @RequestMapping("server/getFoodType")
    List<FoodType> getType();

}
