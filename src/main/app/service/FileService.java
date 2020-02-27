package main.app.service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileService {
    public String getFiles() {
        return null;
    }

    public void saveFile(MultipartFile file, String path) throws IOException {

        Path filepath = Paths.get(path);

        try (OutputStream os = Files.newOutputStream(filepath)) {
            os.write(file.getBytes());
        }
    }

    public String getFile(String path) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            return readAllLines(reader);
        }
    }

    public String readAllLines(BufferedReader reader) throws IOException {
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
        }

        return content.toString();
    }
}
