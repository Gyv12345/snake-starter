package cn.yt4j.common.dto;

import lombok.Data;

/**
 * @author shichenyang
 */
@Data
public class PasswordDTO {

    private String oldPwd;

    private String newPwd;
}
