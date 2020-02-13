package cn.yt4j.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author shichenyang
 */
@ToString
@Data
@ApiModel(value = "响应信息")
public class R<T> implements Serializable {

    private static final long serialVersionUID = -6101337183914807339L;
    @ApiModelProperty("编码")
    private int status;
    @ApiModelProperty("返回信息")
    private String message;
    @ApiModelProperty("返回数据")
    private T data;


    public static <T> R<T> ok() {
        return restResult(null, HttpStatus.OK.value(), null);
    }

    public static <T> R<T> ok(T data) {
        return restResult(data, HttpStatus.OK.value(), null);
    }

    public static <T> R<T> ok(String message) {
        return restResult(null, HttpStatus.OK.value(), message);
    }

    public static <T> R<T> ok(T data, String message) {
        return restResult(data, HttpStatus.OK.value(), message);
    }

    public static <T> R<T> failed() {
        return restResult(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), null);
    }

    public static <T> R<T> failed(String message) {
        return restResult(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    public static <T> R<T> failed(T data) {
        return restResult(data,HttpStatus.INTERNAL_SERVER_ERROR.value(), null);
    }

    public static <T> R<T> failed(T data, String message) {
        return restResult(data, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    private static <T> R<T> restResult(T data, int status, String message) {
        R<T> apiResult = new R<>();
        apiResult.setStatus(status);
        apiResult.setData(data);
        apiResult.setMessage(message);
        return apiResult;
    }


}
