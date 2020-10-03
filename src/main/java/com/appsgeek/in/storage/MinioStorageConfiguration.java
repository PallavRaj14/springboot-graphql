package com.appsgeek.in.storage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

import java.net.URI;

@Configuration
public class MinioStorageConfiguration {

    @Value("${minio.endpoint-url}")
    private String endpointUrl;

    @Value("${minio.access-key-id}")
    private String accessKey;

    @Value("${minio.secret-key-id}")
    private String secretKey;

    @Value("${minio.region}")
    private String region;

    @Value("${minio.bucket}")
    private String bucket;

    @Bean
    public S3Client s3Client(){
        AwsBasicCredentials credentials = AwsBasicCredentials.create(accessKey, secretKey);
        return S3Client.builder()
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .endpointOverride(URI.create(endpointUrl))
                .region(Region.of(region))
                .build();
    }

    @Bean
    public ObjectRepository s3ObjectRepository(S3Client client){
        return new S3ObjectRepository(s3Client(), bucket);
    }
}
