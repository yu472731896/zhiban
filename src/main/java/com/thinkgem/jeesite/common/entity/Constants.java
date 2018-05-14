package com.thinkgem.jeesite.common.entity;

public class Constants {
	public static class ReturnCode {
		/**
		 * 访问成功
		 */
		public static final int CODE_SUCCESS= 0;	
		/**
		 * 访问失败
		 */
		public static final int CODE_FAILURE= -1;	
	}
	
    /**
     * token缓存的key
     */
    public static final String CACHE_TOKEN = "tokenCache";

    /**
     * 存储当前登录用户id的字段名
     */
    public static final String CURRENT_USER_ID = "CURRENT_USER_ID";

    /**
     * 存放Authorization的header字段
     */
    public static final String AUTHORIZATION = "authorization";
}
