package com.spider.test03;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;

public class Result<T> implements Serializable {

  /**
   * 大部分都只有一个出错信息,统一用一个code
   */
  public static final int COMM_CODE = 0;

  /**
   * 参数有问题code
   */
  public static final int ARGS_ERROR = -1;

  /**
   * 服务端异常code
   */
  public static final int SERVER_EXCEPTION = -2;

  /**
   * 业务异常code
   */
  public static final int BIZ_EXCEPTION = -3;


  /**
   *  业务超时
   */
  public static final int TIMEOUT_EXCEPTION = -4;


  /**
   * HIS  报错
   */
  public static  final int HIS_EXCEPTION = -5;

  /**
   * 结算  报错
   */
  public static  final int VS_EXCEPTION = -6;


  /**
   * 排班 报错
   */
  public static  final int APPO_EXCEPTION = -7;

  /**
   * 用户管理 报错
   */
  public static  final int USER_EXCEPTION = -8;

  /**
   * 脱机异常
   */
  public static  final int OFFLINE_EXCEPTION = -9;

  /**
   * HIS 超时 报错
   */
  public static  final int HIS_TIMEOUT_EXCEPTION = -10;

  /**
   * 结算 超时 报错
   */
  public static  final int VS_TIMEOUT_EXCEPTION = -11;


  /**
   * 排班 超时 报错
   */
  public static  final int APPO_TIMEOUT_EXCEPTION = -12;


  /**
   * 卡存在，不能发卡
   */
  public static  final int SEND_CARD_EXIST_EXCEPTION = -13;

  /**
   *
   */
  private static final long serialVersionUID = 5616070434977448606L;

  /**
   * 是否成功.表明:从头到尾没有异常,不代表业务含义
   */
  private boolean success;

  private String msg;

  private int code;

  private final ErrorCodes errorCodes = new ErrorCodes();

  private T data;

  public Result(){
    super();

  }

  private Result(boolean isSucc) {
    this.success = isSucc;

  }

  /**
   * 默认为失败状态
   *
   * @return
   */
  private static <W> Result<W> create() {
      Result<W> result =  new Result<W>(false);
      result.data = null;
     return result;
  }

  public static <W> Result<W> createFailResult() {
    return create();
  }

  public static <W> Result<W> createFailResult(String errorMsg) {
    Result<W> result = create();
    result.error(errorMsg);
    result.data = null;

    return result;
  }

  public static <W> Result<W> createFailResult(int errorCode, String errorMsg) {
    Result<W> result = create();
    result.error(errorCode, errorMsg);
    result.code = errorCode;
    result.data = null;

    return result;
  }

  public static <W> Result<W> createSuccessResult() {
    Result<W> result = create();
    result.setSuccess();

    return result;
  }

  public static <T> Result<T> createSuccessResult(T val) {
    Result<T> result = create();
    result.value(val);

    return result;
  }



  /**
   * result默认isSucc=false <br />
   * 设置value时,会将isSucc=true
   *
   * @param val
   */
  public Result<T> value(T val) {
    this.success = true;
    this.data = val;

    return this;
  }

  public T value() {
    return this.data;
  }

  public T getData() {
    return this.data;
  }

  public void setData(T data) {
    this.data = data;
  }


  public boolean checkArgs(boolean expression, String format, Object... args) {
    if (!expression) {
      this.error(ARGS_ERROR, String.format(format, args));
    }
    return expression;
  }

  /**
   * 设置出错code
   *
   * @param code
   * @param desc
   * @return
   */
  public Result<T> error(int code, String desc) {
    this.success = false;
    data = null;
    errorCodes.add(code, desc);
    this.code = code;
    return this;
  }

  /**
   * 设置出错信息
   *
   * @param code
   * @return
   */
  public Result<T> error(int code) {
    data = null;
    this.code = code;
    return this.error(code, "");
  }

  public Result<T> error(String errMsg) {
      data = null;
    return this.error(COMM_CODE, errMsg);
  }

  /**
   * 返回第一个出错信息
   * 
   * @return
   */
  public String errorMess() {
    return this.errors().one().getDesc();
  }

  /**
   * catch的异常.直接显示服务端异常
   *
   * @return
   */
  public Result<T> exception() {
    return this.error(SERVER_EXCEPTION, "服务器端异常 ->" + id());
  }

  /**
   * 是否成功
   *
   * @return
   */
  public boolean isSuccess() {
    return this.success;
  }

  /**
   * 设置成功
   *
   * @return
   */
  public void setSuccess() {
    this.success = true;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  /**
   * 返回出错信息 应该以isSucc()来判定是否成功.<br />
   * 失败后,再获取出错信息
   *
   * @return
   */
  public ErrorCodes errors() {
    return this.errorCodes;
  }

  private static String id() {
    return HOSTNAME + "-" + System.currentTimeMillis();
  }

  private static final String HOSTNAME = System.getenv().get("COMPUTERNAME");

  @Override
  public String toString() {
    this.msg = getMsg();
    return ReflectionToStringBuilder.toString(this);
  }

  public String getMsg() {
    if(StringUtils.isBlank(this.errors().one().getDesc())){
        return msg;
    }

    return this.errors().one().getDesc();
  }

  public int getCode() {
    return this.code;
  }

}
