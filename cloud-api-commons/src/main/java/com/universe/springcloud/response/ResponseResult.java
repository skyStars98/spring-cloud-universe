package com.universe.springcloud.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Author: daiguoqing
 * @Date: 2020/3/15
 * @Time: 10:04 下午
 * @Version: spring-cloud-universe 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult<T> {

    private Integer code;

    private Boolean status;

    private String message;

    private T result;

    public ResponseResult(Integer code, Boolean status, String message){
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public static <T> ResponseResult<T> success(String message, T result){
        return new ResponseResult(ResponseCode.SUCCESS, true, message, result);
    }

    public static <T> ResponseResult<T> success(T result){
        return ResponseResult.success("success", result);
    }

    public static <T> ResponseResult<T> fail(String message){
        return new ResponseResult(ResponseCode.FAIL, false, message);
    }

    public static <T> ResponseResult<T> fail(){
        return ResponseResult.fail("fail");
    }

}
