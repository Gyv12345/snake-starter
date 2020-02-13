package cn.yt4j.qiniu.service.impl;

import cn.yt4j.qiniu.property.QiNiuProperties;
import cn.yt4j.qiniu.service.QiNiuService;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * @author gyv12345@163.com
 */
@Service
public class QiNiuServiceImpl implements QiNiuService {
    @Autowired
    private UploadManager uploadManager;
    @Autowired
    private BucketManager bucketManager;
    @Autowired
    private Auth auth;
    @Autowired
    private QiNiuProperties qiNiuProperties;
    @Override
    public Response uploadStream(InputStream stream, String key, boolean existed) throws QiniuException {
        Response response;
        if (existed) {
            response = this.uploadManager.put(stream, key, getUploadToken(key),null,null);
        } else {
            response = this.uploadManager.put(stream, key, getUploadToken(),null,null);
            int retry = 0;
            while (response.needRetry() && retry < 3) {
                response = this.uploadManager.put(stream, key, getUploadToken(),null,null);
                retry++;
            }
        }
        return response;
    }

    @Override
    public void deleteFile(String key) throws QiniuException {
        bucketManager.delete(qiNiuProperties.getBucketName(), key);
    }
    /**
     * 获取上传凭证，覆盖上传
     */
    private String getUploadToken(String fileName) {
        return this.auth.uploadToken(qiNiuProperties.getBucketName(), fileName);
    }

    private String getUploadToken(){
        return this.auth.uploadToken(qiNiuProperties.getBucketName());
    }



}
