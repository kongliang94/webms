package com.kongl.cms.common.constant;

public enum ResultCode {

	// 成功
	GLOBAL_SUCCESS("0000","成功"),
	//失败
	GLOBAL_ERROR("9999", "系统正在维护中,请稍后再试!"),



	/**通用 */
	GLOBAL_LOGIN_NAME_NULL("0501","用户名不能为空"),
	GLOBAL_LOGIN_PASS_NULL("0502","密码不能为空"),

	GLOBAL_LOGIN_FAIL("0503","用户名或密码不匹配"),

	GLOBAL_LOGIN_ERROR("0504","系统登录异常"),




	RES_SAVE_ERROR("1501","资源信息保存失败"),
	ROLE_SAVE_ERROR("1502","角色信息保存失败"),
	USER_SAVE_ERROR("1503","用户信息保存失败"),
	USER_ROLE_SAVE_ERROR("1504","用户分配角色信息失败"),
	USER_FAIL_ERROR("1505","失效用户失败,程序异常"),
	ROLE_FAILK_ERROR("1506","失效角色失败,程序异常"),
	RES_FAILK_ERROR("1507","失效资源失败,程序异常"),
	USER_ROLE_DELETE_ERROR("1508","删除用户信息失败"),
	USER_ROLE_DELETE_SUCCESS("1509","删除用户信息成功")
	;

	ResultCode(String code, String msg) {
			this.code = code;
			this.msg = msg;
		}

		private String code;

		private String msg;
		

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}
}
