package com.gundam.unicorn.entity;

import com.gundam.unicorn.utils.StringUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 通用实体字段封装
 * @author kampf
 * @date 2019/7/18 10:43
 */
@Data
public abstract class BaseEntity implements Serializable {

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
        StringBuffer sb = new StringBuffer();
        sb.append(getClass().getSimpleName());
        sb.append("id:").append(id);
        sb.append(", createData:").append(createData);
        sb.append(", createName:").append(createName);
        sb.append(", status:").append(status);
        sb.append(", remark:").append(remark);
        return  sb.toString();
    }
}