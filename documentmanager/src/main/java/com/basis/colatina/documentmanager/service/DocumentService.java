package com.basis.colatina.documentmanager.service;

import com.basis.colatina.documentmanager.config.ApplicationProperties;
import com.basis.colatina.documentmanager.service.dto.DocumentDTO;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.UploadObjectArgs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final MinioClient minioClient;
    private final ApplicationProperties applicationProperties;

    public String uploadFile(DocumentDTO documentDTO) throws IOException {
        try {
            ObjectWriteResponse objectWriteResponse = minioClient.uploadObject(UploadObjectArgs.builder()
                    .bucket(applicationProperties.getBucket())
                    .object(documentDTO.getFile())
                    .filename("/home/basis/Downloads/Log_tracking.csv").build());

            return objectWriteResponse.etag();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
