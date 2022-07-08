package com.yqp.common;

/**
 * 返回数据对象
 *
 * @author yqp
 */
public class ResponseJson {

    private Integer code = 200;
    private String msg = "操作成功";
    private Object data = new JSONObject();
    private PageInfo pageInfo = new PageInfo();

    //构造
    public ResponseJson() {
        super();
    }

    public ResponseJson(Integer code, String msg, Object data, PageInfo pageInfo) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.pageInfo = pageInfo;
    }

    public ResponseJson(Integer code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseJson(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public ResponseJson(Object data, PageInfo pageInfo) {
        super();
        this.data = data;
        this.pageInfo = pageInfo;
    }

    public ResponseJson(Object data) {
        super();
        this.data = data;
    }

    //属性


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

}
