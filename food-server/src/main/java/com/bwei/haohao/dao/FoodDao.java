package com.bwei.haohao.dao;

import com.bwei.haohao.bean.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FoodDao extends JpaRepository<Food,Integer>, JpaSpecificationExecutor {

}
