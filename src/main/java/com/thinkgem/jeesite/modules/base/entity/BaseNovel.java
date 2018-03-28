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
public class BaseNovel extends DataEntity<BaseNovel> {
	
	private static final long serialVersionUID = 1L;
	private String authorId;		// 作者
	private String name;		// 小说名称
	private Date inDate;		// 加入日期
	private String synopsis;		// 简介
	private String novelKind;		// 小说类别
	private String path;		// 图片
	private String state;		// 状态
	
	public BaseNovel() {
		super();
	}

	public BaseNovel(String id){
		super(id);
	}

	@Length(min=0, max=64, message="作者长度必须介于 0 和 64 之间")
	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	
	@Length(min=0, max=20, message="小说名称长度必须介于 0 和 20 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	
	@Length(min=0, max=2000, message="简介长度必须介于 0 和 2000 之间")
	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	@Length(min=0, max=1, message="小说类别长度必须介于 0 和 1 之间")
	public String getNovelKind() {
		return novelKind;
	}

	public void setNovelKind(String novelKind) {
		this.novelKind = novelKind;
	}
	
	@Length(min=0, max=255, message="图片长度必须介于 0 和 255 之间")
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	@Length(min=0, max=1, message="状态长度必须介于 0 和 1 之间")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}