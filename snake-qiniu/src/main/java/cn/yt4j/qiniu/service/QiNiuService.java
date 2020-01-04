package cn.yt4j.qiniu.service;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;

import java.io.InputStream;

/**
 * @author gyv12345
 */
public interface QiNiuService {

    /**
     * 流的方式进行上传
     * @param stream
     * @param key
     * @param existed
     * @return
     * @throws QiniuException
     */
    Response uploadStream(InputStream stream, String key, boolean existed) throws QiniuException;

    /**
     * 删除
     *
     * @param key 添加上传的key值
     * @throws QiniuException 抛出QiniuException异常
     */
    void deleteFile(String key) throws QiniuException;

    /**
     * 获取上传token
     * <p>获取token</p>
     *
     * @return 返回String
     * @throws QiniuException 抛出QiniuException异常
     */
    String getUploadToken() throws QiniuException;
}
