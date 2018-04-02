/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.base.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.base.entity.BaseTurnPicture;

/**
 * 轮播图DAO接口
 * @author minghui
 * @version 2018-04-02
 */
@MyBatisDao
public interface BaseTurnPictureDao extends CrudDao<BaseTurnPicture> {
	
}