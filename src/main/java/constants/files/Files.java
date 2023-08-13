package constants.files;


import helper.FileHelper;

import java.io.File;

public class Files {
    public static class TestDataFiles {
        public static final File PRODUCTS = FileHelper.getFromTestData(JsonFileNames.PRODUCTS);
    }
}