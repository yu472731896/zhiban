/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.base.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 小说用户表信息表Entity
 * @author minghui
 * @version 2018-02-22
 */
public class BaseNovelUser extends DataEntity<BaseNovelUser> {
	
	private static final long serialVersionUID = 1L;
	private String loginName;		// 登陆名
	private String passWord;		// 密码
	private String realName;		// real_name
	private String path;		// 头像
	private String userName;		// 用户名
	private String email;		// email
	private String phoneNumber;		// 电话号
	private String sex;		// sex
	private Date birthday;		// 出生日期
	private Integer novelUserType;		// 小说用户类型标志 0.读者  1.作者（默认0）
	
	public BaseNovelUser() {
		super();
	}

	public BaseNovelUser(String id){
		super(id);
	}

	@Length(min=0, max=16, message="登陆名长度必须介于 0 和 16 之间")
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	@Length(min=0, max=24, message="密码长度必须介于 0 和 24 之间")
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	@Length(min=0, max=12, message="real_name长度必须介于 0 和 12 之间")
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	@Length(min=0, max=255, message="头像长度必须介于 0 和 255 之间")
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	@Length(min=0, max=12, message="用户名长度必须介于 0 和 12 之间")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Length(min=0, max=32, message="email长度必须介于 0 和 32 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Length(min=0, max=11, message="电话号长度必须介于 0 和 11 之间")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Length(min=0, max=1, message="sex长度必须介于 0 和 1 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public Integer getNovelUserType() {
		return novelUserType;
	}

	public void setNovelUserType(Integer novelUserType) {
		this.novelUserType = novelUserType;
	}
	
}