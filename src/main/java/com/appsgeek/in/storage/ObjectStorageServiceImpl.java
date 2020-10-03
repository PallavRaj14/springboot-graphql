package com.appsgeek.in.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjectStorageServiceImpl implements ObjectStorageService {

    private final ObjectRepository repository;

    @Autowired
    public ObjectStorageServiceImpl(ObjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean save(String path, FileObject object) {
        return repository.save(path, object);
    }
}
