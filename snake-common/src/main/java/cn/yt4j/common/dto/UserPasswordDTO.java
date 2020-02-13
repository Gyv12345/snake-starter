package cn.yt4j.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author shichenyang
 */
@Data
@ApiModel("登录")
public class UserPasswordDTO implements Serializable {

    private static final long serialVersionUID = -8785371461393774456L;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("密码")
    private String password;
}
