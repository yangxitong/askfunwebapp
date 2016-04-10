package cn.com.lewen.common;

public enum ResponseCode {
	
	SUCCESS("0000","成功"),
	PARAM_ILLEGAL("1000","参数不合法"),
	RESULT_NULL("1001","返回空结果集"),
	SERVICE_EXCEPTION("1002","服务器异常");
		
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

	private ResponseCode(String code,String msg){
		this.code = code;
		this.msg = msg;
	}
	
}
