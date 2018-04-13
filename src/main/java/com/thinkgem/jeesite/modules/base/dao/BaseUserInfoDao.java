/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.base.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.base.entity.BaseUserInfo;

/**
 * 用户基础信息DAO接口
 * @author minghui
 * @version 2018-04-13
 */
@MyBatisDao
public interface BaseUserInfoDao extends CrudDao<BaseUserInfo> {
	
}