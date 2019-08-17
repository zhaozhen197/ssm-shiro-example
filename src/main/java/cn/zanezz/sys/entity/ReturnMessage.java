package cn.zanezz.sys.entity;

public class ReturnMessage {
    private  String msg;

    private String statusCode;


    public ReturnMessage() {
    }

    public ReturnMessage(String msg, String statusCode) {
        this.msg = msg;
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "ReturnMessage{" +
                "msg='" + msg + '\'' +
                ", statusCode='" + statusCode + '\'' +
                '}';
    }


}
