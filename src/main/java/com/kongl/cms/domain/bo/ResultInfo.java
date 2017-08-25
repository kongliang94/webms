package com.kongl.cms.domain.bo;

import com.kongl.cms.common.constant.ResultCode;


public class ResultInfo {

	//返回提示码Code
    private String returnCode;
    //返回描述
    private String returnMessage;
    //返回数据
    private Object returnData;


    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public Object getReturnData() {
        return returnData;
    }

    public void setReturnData(Object returnData) {
        this.returnData = returnData;
    }
    
    public static ResultInfo returnCodeMessage(ResultCode resultCode){
    	return returnCodeMessage(resultCode, null);
    }
    
    /**
     * 返回消息代码和数据
     *
     * @param bussinessCode 返回码
     * @param returnData    返回数据
     * @return
     */
    public static ResultInfo returnCodeMessage(ResultCode resultCode, Object returnData) {
    	ResultInfo resultInfo=new ResultInfo();
    	resultInfo.setReturnCode(resultCode.getCode());
    	resultInfo.setReturnMessage(resultCode.getMsg());
    	resultInfo.setReturnData(returnData);
    	
    	return resultInfo;
    }
}
