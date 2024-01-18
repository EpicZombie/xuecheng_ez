package com.xuecheng.media;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import io.minio.errors.*;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.io.IOUtil;
import org.springframework.util.DigestUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class MinioTest {

    MinioClient minioClient =
            MinioClient.builder()
                    .endpoint("http://localhost:9000")
                    .credentials("minioadmin", "minioadmin")
                    .build();

    @Test
    public void test_upload() throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

        UploadObjectArgs asiatrip = UploadObjectArgs.builder()
                .bucket("testbucket")
                .object("tp.jpeg")
                .filename("E:\\tp.jpeg")
                .build();

        minioClient.uploadObject(asiatrip);
    }


    public void test_download() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

        GetObjectArgs getArgs = GetObjectArgs.builder().bucket("testbucket").object("test/01/1.mp4").build();
        FilterInputStream inputStream = minioClient.getObject(getArgs);
        FileOutputStream outputStream = new FileOutputStream(new File("D:\\develop\\upload\\1.jpeg"));
        IOUtils.copy(inputStream,outputStream);
        //
        DigestUtils.md5DigestAsHex(inputStream);



    }
}
