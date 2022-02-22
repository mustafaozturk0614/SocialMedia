package com.bilgeadam.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.bilgeadam.constans.S3Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class S3ManagerService {

    @Value("${s3.accesskey}")
    String S3CONFIG_KEY;
    @Value("${s3.secretkey}")
    String s3CONFIG_SECRETKEY;

    AWSCredentials awsCredentials;
    AmazonS3 s3client;

    private void openS3Connection() {
        awsCredentials = new BasicAWSCredentials(S3CONFIG_KEY, s3CONFIG_SECRETKEY);
        s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(S3Config.S3_BUCKET_REGION).build();
    }
    //                                 dosyadı,   resim datası
    public Optional<PutObjectResult> putObject(String key, MultipartFile file) {
        try {
            openS3Connection();
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType("image/png");
            metadata.setContentLength(file.getSize());
            PutObjectResult result = s3client.putObject(S3Config.S3_BUCKET_USER,key,file.getInputStream(),metadata);
            return Optional.of(result);
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
