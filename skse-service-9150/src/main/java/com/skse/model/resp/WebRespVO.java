package com.skse.model.resp;

/**
 * @Author jiangyao
 * @Date 2020/5/12 13:41
 **/
public class WebRespVO<T> {

    public static volatile WebRespVO webRespVO = new WebRespVO();

    private String code;

    private String msg;

    private T t;

    private WebRespVO(){}

    private WebRespVO(String code, String msg){
        this.msg = msg;
        this.code = code;
    }

    private WebRespVO(String code, String msg, T t){
        this.msg = msg;
        this.code = code;
        this.t = t;
    }

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

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static WebRespVO failResp(String code, String msg){
        webRespVO.setCode(code);
        webRespVO.setMsg(msg);
        return webRespVO;
    }

    public static WebRespVO successResp(String code, String msg, Object o){
        webRespVO.setCode(code);
        webRespVO.setMsg(msg);
        webRespVO.setT(o);
        return webRespVO;
    }

    public static WebRespVO successResp(String code, String msg){
        webRespVO.setCode(code);
        webRespVO.setMsg(msg);
        return webRespVO;
    }
}
