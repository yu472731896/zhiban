/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.base.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.base.entity.BaseNovelUser;

/**
 * 小说用户表信息表DAO接口
 * @author minghui
 * @version 2018-02-22
 */
@MyBatisDao
public interface BaseNovelUserDao extends CrudDao<BaseNovelUser> {
	
}