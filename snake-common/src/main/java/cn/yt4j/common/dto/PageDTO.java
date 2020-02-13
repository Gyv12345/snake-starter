package cn.yt4j.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 分页帮助类
 * @author shichenyang
 */
@Data
@ApiModel("分页请求对象")
public class PageDTO<T> implements Serializable {

    private static final long serialVersionUID = 5799505573612410204L;
    @ApiModelProperty(value = "当前页数")
    private Integer current;
    @ApiModelProperty(value = "显示条数")
    private Integer pageSize;
    @ApiModelProperty("查询参数")
    private T data;
}
