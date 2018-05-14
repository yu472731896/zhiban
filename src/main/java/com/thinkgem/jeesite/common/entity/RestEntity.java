package com.thinkgem.jeesite.common.entity;

/**
 * 自定义返回结果
 *
 * @author XieEnlong
 * @date 2015/7/14.
 */
public class RestEntity {

	/**
	 * 返回码
	 */
	private int code;

	/**
	 * 返回结果描述
	 */
	private String msg;

	/**
	 * 返回内容
	 */
	private Object data;

	private RestEntity(int code, String msg) {
		this.code = code;
		this.msg = msg;
		this.data = "";
	}

	private RestEntity(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public Object getData() {
		return data;
	}

	/**
	 * @param status
	 *            类型
	 */
	private RestEntity(RestStatus status) {
		this.code = status.getCode();
		this.msg = status.getMessage();
		this.data = "";
	}

	private RestEntity(RestStatus status, Object data) {
		this.code = status.getCode();
		this.msg = status.getMessage();
		this.data = data;
	}

	/**
	 * 成功
	 * 
	 * @param data
	 *            要返回的数据
	 * @return
	 */
	public static RestEntity ok(Object data) {
		return new RestEntity(RestStatus.SUCCESS, data);
	}

	/**
	 * 成功
	 * 
	 * @param status
	 *            成功的状态
	 * @param data
	 * @return
	 */
	public static RestEntity ok(RestStatus status, Object data) {
		return new RestEntity(status, data);
	}

	/**
	 * 成功，不返回任何数据
	 * 
	 * @return
	 */
	public static RestEntity ok() {
		return new RestEntity(RestStatus.SUCCESS);
	}

	/**
	 * 失败,调用这个方法需要到 RestStatus 声明好枚举类
	 * 
	 * @see com.ctop.www.common.entiry.RestStatus
	 * @param error
	 *            失败类型
	 * @return
	 */
	public static RestEntity error(RestStatus error) {
		return new RestEntity(error);
	}

	/**
	 * 失败,自行传入错误代码与错误原因
	 * 
	 * @param code
	 *            错误码
	 * @param msg
	 *            失败原因
	 * @return
	 */
	public static RestEntity error(int code, String msg) {
		return new RestEntity(code, msg);
	}

	/**
	 * 构建返回数据，自行传入错误代码与错误原因
	 * 
	 * @param data
	 *            要返回的数据
	 * @return
	 */
	public static RestEntity build(int code, String msg) {
		return new RestEntity(code, msg);
	}

	/**
	 * 构建返回数据，自行传入代码与返回信息，以及要返回的数据
	 * 
	 * @return
	 */
	public static RestEntity build(int code, String msg, Object data) {
		return new RestEntity(code, msg, data);
	}
}
