/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kit.migrator.datamigrator.service;

import com.kit.migrator.datamigrator.config.MinioConfig;
import io.minio.*;

import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anwarul.islam
 */
@Service
@Slf4j
public class FileStorageService {

    @Autowired
    MinioClient minioClient;

    

    public InputStream getInputStream(String url) throws Exception {
        return minioClient.getObject(
                GetObjectArgs
                        .builder()
                        .bucket(MinioConfig.COMMON_BUCKET_NAME)
                        .object(url)
                        .build());
    }

    public byte[] getObjectAsByte(String url) throws Exception {
        if (StringUtils.isEmpty(url)) {
            return null;
        }
        InputStream is = getInputStream(url);
        return IOUtils.toByteArray(is);
    }
}
