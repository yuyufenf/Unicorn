package com.gumdan.unicorn.entity;

import com.gumdan.unicorn.utils.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @author kampf
 * @date 2019/7/18 10:43
 */
public abstract class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 2791885284390539379L;

    protected String id;

    protected Date createData;

    protected String createName;

    protected int status;

    protected String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateData() {
        return createData;
    }

    public void setCreateData(Date createData) {
        this.createData = createData;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    protected BaseEntity(){
        this.id = StringUtils.mkUUID();
        this.createData = new Date(System.currentTimeMillis());
        this.status = 1;
    }

    @Override
    public String toString() {
        return  "id='" + id + '\'' + "\n" +
                "createData='" + createData + '\'' + "\n"+
                "createName='" + createName + '\'' + "\n" +
                "status='" + status + '\'' + "\n" +
                "remark='" + remark + '\'' + "\n" ;
    }
}