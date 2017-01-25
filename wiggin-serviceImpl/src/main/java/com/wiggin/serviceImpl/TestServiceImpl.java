/**
 *
 * copyright 2015-2020
 * @date 2017年1月25日 上午10:27:50
 * @author wiggin
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
package com.wiggin.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiggin.dao.TestMapper;
import com.wiggin.model.Test;
import com.wiggin.service.TestService;

/**
 *
 * @date 2017年1月25日 上午10:27:50
 * @author wiggin
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
@Service("testService")
public class TestServiceImpl implements TestService {

	private static Logger logger = LoggerFactory.getLogger(TestServiceImpl.class); 
	
	@Autowired
	private TestMapper mapper;
	
	/* (non-Javadoc)
	 * @see com.wiggin.service.TestService#qryTest(java.lang.Integer)
	 */
	@Override
	public Test qryTest(Integer id) {
		if (logger.isDebugEnabled()) {
			logger.debug("qryTest id :{}",id);
		}
		
		return mapper.selectById(id);
	}

}
