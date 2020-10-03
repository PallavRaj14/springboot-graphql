package com.appsgeek.in.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public class S3StorageController {

    private final ObjectStorageService service;

    @Autowired
    public S3StorageController(ObjectStorageService service) {
        this.service = service;
    }

    @PostMapping(value = "/add")
    public boolean uploadObjectInBucket(@RequestParam("path") String path, @RequestParam("file") MultipartFile file) {
        FileObject fileObject = FileObjectConverter.toFileObject(file);
        return service.save(path,  fileObject);
    }
}
