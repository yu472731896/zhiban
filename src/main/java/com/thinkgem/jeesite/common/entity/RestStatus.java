package com.thinkgem.jeesite.common.entity;

/**
 * 自定义请求状态码
 *
 * @author yooranchen
 * @date 2017/12/28.
 */
public enum RestStatus {
    /**
     * 访问成功
     */
    SUCCESS(0, "访问成功"),
    /**
     * 访问失败
     */
    ERROR(-1, "访问失败"),
    /**
     * 用户名或密码错误
     */
    USERNAME_OR_PASSWORD_ERROR(-2, "用户名或密码错误"),
    /**
     * 用户不存在
     */
    USER_NOT_FOUND(-3, "用户不存在"),
    /**
     * 用户未登录
     */
    USER_NOT_LOGIN(-4, "用户未登录"),
    /**
     * TOKEN过期或者不可用
     */
    TOKEN_UN_USABLE(-5, "token已过期,请重新登录");

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回结果描述
     */
    private String message;

    RestStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
