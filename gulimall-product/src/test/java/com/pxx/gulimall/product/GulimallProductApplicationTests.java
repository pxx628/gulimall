package com.pxx.gulimall.product;

import com.pxx.gulimall.common.utils.UpTencentUtils;
import com.pxx.gulimall.product.entity.BrandEntity;
import com.pxx.gulimall.product.service.BrandService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;
    @Test
    void contextLoads() {
        BrandEntity brand = new BrandEntity();
        brand.setName("杜蕾斯");
        brand.setLogo("LOVE");
        brand.setSort(1);
        brand.setDescript("你好她也好");
//        brand.setFirstLetter("高级");
        brand.setShowStatus(1);

        brandService.save(brand);
        System.out.println("保存完成===================");
    }
    @Test
    void contextLoads1() {
        System.out.println(brandService.query());
    }


    @Test
    public void testUp(){
        // 1 初始化用户身份信息（secretId, secretKey）。
    // SECRETID和SECRETKEY 请登录访问管理控制台 https://console.cloud.tencent.com/cam/capi 进行查看和管理
        String secretId = "AKIDc5Xv6fplTxDG5f1HK9jGahU7WgcJtHSP";
        String secretKey = "wd6LL6ctwsa3JZdT5TcWBuRkofQzKSP8";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
    // 2 设置 bucket 的地域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
    // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-chongqing");
        ClientConfig clientConfig = new ClientConfig(region);
    // 这里建议设置使用 https 协议
    // 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);
    // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);

        String fileAddr="D:\\Documentation\\picture\\my\\QQ截图20220914161127.png";
        // 指定要上传的文件
        File localFile = new File(fileAddr);
        // 指定文件将要存放的存储桶
        String bucketName = "gulimall-hello-1313719209";
        // 指定文件上传到 COS 上的路径，即对象键。例如对象键为 folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
        String key = "test.png";
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);


        System.out.println("上传完成================================================");

    }




    @Test
    public void testUp2(){
        System.out.println();


    }



}
