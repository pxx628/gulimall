package com.pxx.gulimall.common.utils;

import com.alibaba.nacos.common.utils.UuidUtils;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.context.annotation.Bean;
import java.io.File;

import java.util.Calendar;




public class UpTencentUtils {
    @Bean
    public static String tencentCos(String secretId,String secretKey,String bucket,String region,File file){
        //生成唯一文件名
        String newFileName = UuidUtils.generateUuid()+"_"+file.getName();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DATE);
        //文件在存储桶中的key
        String key = year + "-" + month + "-" + day + "/" + newFileName;
        //声明客户端
        COSClient cosClient = null;
        try {
            //初始化用户身份信息(secretId,secretKey)
            COSCredentials cosCredentials = new BasicCOSCredentials(secretId, secretKey);
            //设置bucket的区域
            ClientConfig clientConfig = new ClientConfig(new Region(region));
            //生成cos客户端
            cosClient = new COSClient(cosCredentials, clientConfig);
            //创建存储对象的请求
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, key, file);
            //执行上传并返回结果信息
//            new PutObjectRequest(bucketName)
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            return "https://gulimall-hello-1313719209.cos.ap-chongqing.myqcloud.com/"+key;
        } catch (CosClientException e) {
            return e.toString();
        } finally {
            // 关闭客户端(关闭后台线程)
            cosClient.shutdown();
        }
    }
}
