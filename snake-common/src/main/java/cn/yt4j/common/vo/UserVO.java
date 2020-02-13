package cn.yt4j.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 这个是给UI使用的VO类
 * @author shichenyang
 */
@Data
@ApiModel("用户返回")
public class UserVO implements Serializable {
    private static final long serialVersionUID = 5464105864366860342L;

    @ApiModelProperty(value = "用户信息")
    private UserInfo userInfo;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String username;
    
    @ApiModelProperty(hidden = true)
    private String password;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @ApiModelProperty(value = "电子邮箱")
    private String email;

    @ApiModelProperty(value = "默认岗位")
    private Long defaultPosition;

    @ApiModelProperty(value = "删除", example = "1")
    private Integer isDelete;

    @ApiModelProperty(value = "状态", example = "1")
    private Integer state;

    @ApiModelProperty(value = "用户所有岗位")
    List<Map<String, Object>> positions ;

    @ApiModelProperty(value = "用户所有角色",hidden = true)
    List<String> roles;

    @ApiModelProperty(value = "用户所有权限",hidden = true)
    List<String> permission;

    @ApiModelProperty(value = "用户默认岗位所属部门")
    private String deptCode;
    @ApiModelProperty(value = "用户默认岗位所属部门名称")
    private String deptName;

    @ApiModelProperty(value = "权限等级", example = "1")
    private Integer level;
}
