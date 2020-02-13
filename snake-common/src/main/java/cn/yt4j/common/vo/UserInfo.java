package cn.yt4j.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 给UI使用的帮助类
 * @author shichenyang
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInfo implements Serializable {

    private String username;

    private String name;

    private String avatar;

    private String positionName;

    private String deptCode;

    private String deptName;
}
