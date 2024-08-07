package com.marlonnunes.localstack.service;

import com.marlonnunes.localstack.MessageDTO;
import com.marlonnunes.localstack.publisher.Publisher;
import io.awspring.cloud.s3.ObjectMetadata;
import io.awspring.cloud.s3.S3Resource;
import io.awspring.cloud.s3.S3Template;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class S3Service {

    @Value("${aws.bucket-name}")
    private String bucketName;

    private final S3Template s3Template;
    private final Publisher publisher;

    public String uploadImage(String key, MultipartFile file) {
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            log.error("Error uploading image to S3", e);
            return "Error uploading image to S3";
        }
        String contentType = Objects.nonNull(file.getContentType()) ? file.getContentType() : "image/jpeg";

        ObjectMetadata metadata = ObjectMetadata.builder().contentType(contentType).build();

        S3Resource s3Response = s3Template.upload(bucketName, key, inputStream, metadata);
        String url;
        try {
            url = s3Response.getURL().toString();
        } catch (IOException e) {
            log.error("Error getting URL from S3", e);
            return "Error getting URL from S3";
        }

        this.publisher.publish(new MessageDTO(key, url));

        return url;
    }
}
