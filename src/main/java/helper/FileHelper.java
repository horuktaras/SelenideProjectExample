package helper;

import commons.StringFormatUtil;
import constants.files.DirPath;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import static java.lang.Thread.currentThread;

public class FileHelper {

    public static File getFromResources(String fileName) {
        URL resource = currentThread().getContextClassLoader().getResource(fileName);
        return getFile(resource, fileName);
    }

    public static File getFromTestData(String fileName) {
        URL resource = currentThread().getContextClassLoader().getResource(StringFormatUtil.concatenation(DirPath.TEST_DATA, fileName));
        return getFile(resource, fileName);
    }

    private static File getFile(URL resource, String fileName) {
        try {
            if (resource == null) {
                throw new IllegalArgumentException("File not found in classpath: " + fileName);
            }
            File testResourcesDir = new File(resource.toURI());
            if (!testResourcesDir.exists()) {
                throw new RuntimeException("File name: " + fileName + " is invalid");
            }
            return testResourcesDir;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}