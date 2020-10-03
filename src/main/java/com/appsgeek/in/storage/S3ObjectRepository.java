package com.appsgeek.in.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

public class S3ObjectRepository implements ObjectRepository {

    private final S3Client s3Client;
    private final String bucket;

    public S3ObjectRepository(S3Client s3Client, String bucket) {
        this.s3Client = s3Client;
        this.bucket = bucket;
    }


    @Override
    public boolean save(String path, FileObject object) {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucket)
                .key(path)
                .build();
        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(object.data));
        return true;
    }
}
