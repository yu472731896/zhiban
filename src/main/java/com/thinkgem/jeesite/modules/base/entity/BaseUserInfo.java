/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.base.entity;

import com.thinkgem.jeesite.modules.sys.entity.User;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 用户基础信息Entity
 * @author minghui
 * @version 2018-04-13
 */
public class BaseUserInfo extends DataEntity<BaseUserInfo> {
	
	private static final long serialVersionUID = 1L;
	private User user;		// 用户主键
	private String entName;		// 企业名称
	private String accessAmount;		// 浏览量
	private String phone;		// 联系电话
	private String weixin;		// weixin
	private String weixinMa;		// 微信二维码图片
	
	public BaseUserInfo() {
		super();
	}

	public BaseUserInfo(String id){
		super(id);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Length(min=0, max=100, message="企业名称长度必须介于 0 和 100 之间")
	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}
	
	@Length(min=0, max=100, message="浏览量长度必须介于 0 和 100 之间")
	public String getAccessAmount() {
		return accessAmount;
	}

	public void setAccessAmount(String accessAmount) {
		this.accessAmount = accessAmount;
	}
	
	@Length(min=0, max=11, message="联系电话长度必须介于 0 和 11 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=100, message="weixin长度必须介于 0 和 100 之间")
	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	
	@Length(min=0, max=255, message="微信二维码图片长度必须介于 0 和 255 之间")
	public String getWeixinMa() {
		return weixinMa;
	}

	public void setWeixinMa(String weixinMa) {
		this.weixinMa = weixinMa;
	}
	
}