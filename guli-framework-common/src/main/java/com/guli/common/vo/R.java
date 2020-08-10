package com.guli.common.vo;

import com.guli.common.constant.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.HashMap;
import java.util.Map;

@Data
@ApiModel(value = "全局统一返回结果")
public class R {

    @ApiModelProperty(value = "响应是否成功")
    private Boolean success;

    @ApiModelProperty(value = "响应码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String,Object> data = new HashMap<String,Object>();

    private R(){}

    public static R ok(){
        R r = new R();
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        return r;
    }

    public static R error(){
        R r = new R();
        r.setSuccess(ResultCodeEnum.UNKNOW_ERROR.getSuccess());
        r.setCode(ResultCodeEnum.UNKNOW_ERROR.getCode());
        r.setMessage(ResultCodeEnum.UNKNOW_ERROR.getMessage());
        return r;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public R data(Map<String,Object> map){
        this.setData(map);
        return this;
    }
    public R data(String key,Object value){
        this.data.put(key, value);
        return this;
    }

}
