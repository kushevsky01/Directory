package service.simpleservice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Date;

public class Roots {
    public String getUpdate(File root) throws IOException {
        Path file = Paths.get(String.valueOf(root));
        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
        return String.valueOf(new Date(root.lastModified()));
    }

    public static String getName(File root){
        return root.getName();
    }

    public static String getSize(File root){
        return String.valueOf(root.length());
    }

    public static String getCreationTime(File root) throws IOException {
        Path file = Paths.get(String.valueOf(root));
        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
        String message = Arrays.toString(attr.lastModifiedTime().toString().split("[A-z]"));
        return  message.replaceAll("[\\[\\]]","");
    }
}
