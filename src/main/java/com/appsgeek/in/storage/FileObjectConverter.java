package com.appsgeek.in.storage;

import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

public class FileObjectConverter {

    public static FileObject toFileObject(MultipartFile file) {
        if (file == null) {
            return null;
        }

        FileObject fileObject = new FileObject();

        try {
            fileObject.data = file.getBytes();

        } catch (Exception e) {

        }

        fileObject.imageFormatName = imageFormatName(Objects.requireNonNull(file.getOriginalFilename()));
        fileObject.contentType = file.getContentType();
        return fileObject;
    }

    private static String imageFormatName(String fileName) {
        int lastDotPosition = fileName.lastIndexOf(".");

        if (lastDotPosition == -1) {
            return null;
        }

        return fileName.substring(lastDotPosition + 1);
    }
}
