package com.basis.colatina.documentmanager.service;

import com.basis.colatina.documentmanager.config.ApplicationProperties;
import com.basis.colatina.documentmanager.service.dto.DocumentDTO;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final MinioClient minioClient;
    private final ApplicationProperties applicationProperties;

    @SneakyThrows
    public void uploadFile(DocumentDTO documentDTO) {
        minioClient.putObject(PutObjectArgs.builder()
                .bucket(applicationProperties.getBucket())
                .object(documentDTO.getUuid())
                .stream(new ByteArrayInputStream(documentDTO.getFile().getBytes()), documentDTO.getFile().getBytes().length, 0).build());
    }

    @SneakyThrows
    public String getFile(String uuid) {
        InputStream file = minioClient.getObject(GetObjectArgs.builder()
                .bucket(applicationProperties.getBucket())
                .object(uuid).build());

        return IOUtils.toString(file, StandardCharsets.UTF_8);
    }

    @SneakyThrows
    public void delete(String uuid) {
        minioClient.removeObject(RemoveObjectArgs.builder().bucket(applicationProperties.getBucket()).object(uuid).build());
    }

}
