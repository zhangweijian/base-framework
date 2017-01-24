/**
 *
 * copyright 2015-2020
 * @date 2017年1月21日 下午10:02:26
 * @author wiggin
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
package com.wiggin.common.util.test;

import java.util.Date;
import java.util.List;

/**
 *
 * @date 2017年1月21日 下午10:02:26
 * @author wiggin
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
public class TestBean {

	private Long id;
	private String name;
	private Date birth;
	private List<String> ha;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getHa() {
		return ha;
	}
	public void setHa(List<String> ha) {
		this.ha = ha;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
}
