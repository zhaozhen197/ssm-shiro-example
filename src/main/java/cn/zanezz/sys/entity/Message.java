package cn.zanezz.sys.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
    private Integer messageId;

    private String phone;

    private Integer validateCode;

    private Integer deadLine;

    private Byte usable;

    private Byte sended;

    private Date creationDatetime;

    private Date updateDatetime;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(Integer validateCode) {
        this.validateCode = validateCode;
    }

    public Integer getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Integer deadLine) {
        this.deadLine = deadLine;
    }

    public Byte getUsable() {
        return usable;
    }

    public void setUsable(Byte usable) {
        this.usable = usable;
    }

    public Byte getSended() {
        return sended;
    }

    public void setSended(Byte sended) {
        this.sended = sended;
    }

    public Date getCreationDatetime() {
        return creationDatetime;
    }

    public void setCreationDatetime(Date creationDatetime) {
        this.creationDatetime = creationDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String formateTime(Date date) {
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);

    }
}