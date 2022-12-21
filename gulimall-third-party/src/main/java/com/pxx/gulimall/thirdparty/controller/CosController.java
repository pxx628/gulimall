package com.pxx.gulimall.thirdparty.controller;

import com.pxx.gulimall.common.utils.R;
import com.pxx.gulimall.common.utils.UpTencentUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@RestController
@RequestMapping("/thirdparty/oss/")
public class CosController {
    @Value("${cos.secretId}")
    private String secretId;
    @Value("${cos.secretKey}")
    private String secretKey;
    @Value("${cos.region}")
    private String region;
    @Value("${cos.bucketName}")
    private String bucketName;

    public static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @PostMapping ("/policy")
    public R list(MultipartFile file) throws IOException {
        System.out.println(file+"=============================");
        File toFile = null;
        if (file.equals("") || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }

        String s = UpTencentUtils.tencentCos(secretId, secretKey,bucketName, region, toFile);
        return R.ok().put("data", s);
    }

}
