package com.gundam.unicorn.entity;

import com.gundam.unicorn.utils.StringUtils;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 通用实体字段封装
 * @author kampf
 * @date 2019/7/18 10:43
 */
public abstract class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 2791885284390539379L;

    @ApiModelProperty(value = "字段ID(\"后端自动生成\")", required = true)
    protected String id;

    @ApiModelProperty(value = "创建时间(\"后端自动生成\")")
    protected Date createData;

    @ApiModelProperty(value = "字段创建者")
    protected String createName;

    @ApiModelProperty(value = "字段状态(\"后端生成默认值\")", required = true)
    protected int status;

    @ApiModelProperty(value = "字段备注以及替换")
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

    /**
     * 构造函数初始化
     */
    protected BaseEntity(){
        this.id = StringUtils.mkUUID();
        this.createData = new Date(System.currentTimeMillis());
        this.status = 1;
    }

    /**
     * 打印字段方法
     * @return
     */
    @Override
    public String toString() {
        return  "id='" + id + '\'' + "\n" +
                "createData='" + createData + '\'' + "\n"+
                "createName='" + createName + '\'' + "\n" +
                "status='" + status + '\'' + "\n" +
                "remark='" + remark + '\'' + "\n" ;
    }
}