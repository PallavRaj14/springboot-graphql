package com.appsgeek.in.storage;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FileObject {

    public byte[] data;
    public String imageFormatName;
    public String contentType;
    public Map<String, List<String>> headers;

    public InputStream toInputStream() {
        return data != null ? new ByteArrayInputStream(data) : null;
    }

    public boolean equals(FileObject fileObjectToCompare) {
        if (data == null || fileObjectToCompare.data == null) {
            return false;
        }
        return Arrays.equals(data, fileObjectToCompare.data);
    }
}
