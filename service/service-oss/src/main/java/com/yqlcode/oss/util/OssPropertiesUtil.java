package com.yqlcode.oss.util;/**
 * 描述:
 * 包名:com.yqlcode.oss.util
 * 版本信息: 版本1.0
 * 日期:2021/5/11
 * Copyright XXXX科技有限公司
 */


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @describe：
 * @author: yql/XXXX科技有限公司 
 * @version:v1.0
 * 2021/5/11 19:39  
 */
@Component
public class OssPropertiesUtil implements InitializingBean {
    @Value("${aliyun.oss.file.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.file.keyid}")
    private String keyid;

    @Value("${aliyun.oss.file.keysecret}")
    private String keysecret;

    @Value("${aliyun.oss.file.bucketname}")
    private String bucketname;

    public static String END_POINT;
    public static String KEY_ID;
    public static String KEY_SECRET;
    public static String BUCKET_NAME;
    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = this.endpoint;
        KEY_ID = this.keyid;
        KEY_SECRET = this.keysecret;
        BUCKET_NAME = this.bucketname;
    }
}
