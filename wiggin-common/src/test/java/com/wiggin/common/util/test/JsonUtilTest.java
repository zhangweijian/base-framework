/**
 *
 * copyright 2015-2020
 * @date 2017年1月21日 下午10:03:23
 * @author wiggin
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
package com.wiggin.common.util.test;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.wiggin.common.util.JsonUtil;

/**
 *
 * @date 2017年1月21日 下午10:03:23
 * @author wiggin
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
public class JsonUtilTest {

	@Test
	public void testToJson(){
		System.out.println(new Date());
			List<String> ha = new ArrayList<>();
			ha.add("zwj1");
			ha.add("zwj2");
			TestBean bean = new TestBean();
			bean.setId(new Long(1));
			bean.setName("zwj");
			bean.setHa(ha);
			bean.setBirth(new Date());
		String json = JsonUtil.toJsonString(bean);
		System.out.println(json);
	}
	
	@Test
	public void toObj(){
		String json = "{\"id\":\"1\",\"name\":\"zwj\",\"birth\":\"2017-01-21 22:43:35\"}";
		System.out.println(json);
		TestBean bean = JsonUtil.toObject(json, TestBean.class);
		System.out.println(bean.getBirth());
	}
}
