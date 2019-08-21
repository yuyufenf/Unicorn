package com.gundam.unicorn.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 通用返回响应体，返回JSON，返回格式为
 *  {
 *     code：200
 *     msg：SUCCESS
 *     data：{
 *        JSONKey：JSONValue
 *     }
 *  }
 * @author kampf
 * @date 2019/7/19 11:55
 */
@ApiModel(description = "自定义返回响应类")
public class Result<T> {

    @ApiModelProperty(value = "返回状态码")
    private int code;

    @ApiModelProperty(value = "返回信息")
    private String msg;

    @ApiModelProperty(value = "返回值")
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 打印参数方法
     * @return
     */
    @Override
    public String toString() {
        return  "code='" + code + '\'' + "\n" +
                "msg='" + msg + '\'' + "\n" +
                "data='" + data + '\'';
    }

    /**
     * 请求成功的构造函数
     * @param data
     */
    public Result(T data, String msg){
        this.code = 200;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 请求失败的基本构造函数
     * @param code
     * @param msg
     */
    public Result(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    /**服务端基础异常枚举*/
    public static Result SERVER_ERROR = new Result(500,"系统异常：%s");
    public static Result BIND_ERROR = new Result(501,"(绑定异常)参数校验异常：%s");
    public static Result SESSION_ERROR = new Result(502,"SESSION异常! : %s");
    public static Result REQUEST_ERROR = new Result(503,"非法请求！");
    public static Result REQUEST_OVER_LIMIT = new Result(504,"请求次数过多！");

    /**
     * 成功时调用
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data, String msg){
        return new Result<>(data, msg);
    }

    /**
     * 失败时调用
     * @param result
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(Result result, Object... args){
        String msg = String.format(result.getMsg(), args);
        return new Result<>(result.getCode(), msg);
    }
}
