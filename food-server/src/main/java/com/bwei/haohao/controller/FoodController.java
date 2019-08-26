package com.bwei.haohao.controller;

import com.bwei.haohao.bean.Food;
import com.bwei.haohao.bean.FoodType;
import com.bwei.haohao.dao.FoodDao;
import com.bwei.haohao.dao.FoodTypeDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("server")
@CrossOrigin
public class FoodController {
    @Resource
    private FoodDao foodDao;

    @Resource
    private FoodTypeDao foodTypeDao;

    /**
     * 查询全部
     */
    @RequestMapping("selectfood")
    public Page<Food> selectFood(Integer page,String hname,Date startTime,Date endTime){
        if(page>=1){
            page = page-1;
        }
        PageRequest of = PageRequest.of(page,3);

        Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();

                if(hname!=null && !hname.equals("")) {
                    Predicate rname = criteriaBuilder.like(root.get("fname"), "%"+hname+"%");
                    list.add(rname);
                }
                if(startTime!=null){
                    Predicate createDate = criteriaBuilder.greaterThan(root.get("createDate"), startTime);
                    list.add(createDate);
                }
                if(endTime!=null){
                    Predicate createDate = criteriaBuilder.lessThan(root.get("createDate"),endTime);
                    list.add(createDate);
                }
                //加进去
                Predicate[] predicates = new Predicate[(list.size())];
                predicates=list.toArray(predicates);
                Predicate and = criteriaBuilder.and(predicates);
                return and;
            }
        };

        Page<Food> all = foodDao.findAll(specification,of);
        return all;
    }

    /**
     * 删除
     * @param fids
     * @return
     */
    @RequestMapping("delete")
    public boolean deleteFood(Integer fids[]){
        try {
            for (Integer fid : fids) {
                foodDao.deleteById(fid);
            }
            return  true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 增加或者修改
     * @param food
     * @param tid
     * @return
     */
    @RequestMapping("InsertOrUpdate")
    public boolean InsertOrUpdate(@RequestBody Food food,@RequestParam Integer tid ){
        try {
            if(food.getFid()==null || food.getFid()==0){
                FoodType foodType = foodTypeDao.findById(tid).get();
                food.setFoodType(foodType);
                foodDao.save(food);
            }else {
                foodDao.save(food);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();;
        }
        return false;
    }

    /**
     * 获取附表
     * @return
     */
    @RequestMapping("getFoodType")
    public List<FoodType> getFoodType(){
        return foodTypeDao.findAll();
    }

    /**
     * 获取单个属性信息
     * @param fid
     * @return
     */
    @RequestMapping("getFoodById")
    public Food getFoodById(Integer fid){
        Optional<Food> byId = foodDao.findById(fid);return byId.get();

    }
}
