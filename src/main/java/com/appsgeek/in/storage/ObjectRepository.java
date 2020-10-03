package com.appsgeek.in.storage;

import java.io.File;

public interface ObjectRepository {

    public boolean save(String path, FileObject object);
}
