package com.thinkgem.jeesite.common.security.token.model;


/**
 * 登录返回数据
 */
public class TokenDto {
    private String userId;
    private String token;

    public TokenDto(String userId, String token) {
        this.userId = userId;
        this.token = token;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
