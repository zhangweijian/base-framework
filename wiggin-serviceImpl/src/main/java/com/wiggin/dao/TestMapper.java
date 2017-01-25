package com.wiggin.dao;

import com.wiggin.model.Test;

public interface TestMapper {
	
	Test selectById(Integer id);
	
    int insert(Test record);

    int insertSelective(Test record);
}