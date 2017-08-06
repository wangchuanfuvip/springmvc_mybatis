package cn.itcast.usermanage.vo;

public class MyResult {

    private Integer status;

    private String msg;

    private Object data;

    public MyResult(Integer status, String msg, Object data) {
        super();
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public MyResult() {
    }

    public MyResult(Integer status, String msg) {
        super();
        this.status = status;
        this.msg = msg;
    }

    public static MyResult ok() {
        return new MyResult(200, "OK", null);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

}
