package com.yqlcode.oss.service.impl;/**
 * 描述:
 * 包名:com.yqlcode.oss.service.impl
 * 版本信息: 版本1.0
 * 日期:2021/5/11
 * Copyright XXXX科技有限公司
 */


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.yqlcode.oss.service.OssService;
import com.yqlcode.oss.util.OssPropertiesUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @describe：
 * @author: yql/XXXX科技有限公司 
 * @version:v1.0
 * 2021/5/11 19:47  
 */
@Service
public class OssServiceImpl implements OssService {
    @Override
    public String uploadFile(MultipartFile multipartFile) {
        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = OssPropertiesUtil.END_POINT;
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = OssPropertiesUtil.KEY_ID;
        String accessKeySecret = OssPropertiesUtil.KEY_SECRET;
        String bucketName = OssPropertiesUtil.BUCKET_NAME;

        //获取文件名称
        String fileName = multipartFile.getOriginalFilename();
        //将文件名称与uuid进行拼接，获得唯一文件名,uuid有短横线，一并进行替换
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        fileName = uuid + fileName;
        //拼接日期路径，以将文件放在bucket指定的日期文件夹下
        String nowDate = new DateTime().toString("yyyy/MM/dd");
        fileName = nowDate + fileName;

        try {
            InputStream file = multipartFile.getInputStream();
            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            // 创建PutObjectRequest对象。
            // 填写Bucket名称、Object完整路径和本地文件的完整路径。Object完整路径中不能包含Bucket名称。
            // 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, file);

            // 如果需要上传时设置存储类型和访问权限，请参考以下示例代码。
            // ObjectMetadata metadata = new ObjectMetadata();
            // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
            // metadata.setObjectAcl(CannedAccessControlList.Private);
            // putObjectRequest.setMetadata(metadata);

            // 上传文件。
            ossClient.putObject(putObjectRequest);

            // 关闭OSSClient。
            ossClient.shutdown();
            String url = "https://" + bucketName + "." + endpoint + "/" + fileName;
            return url;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
