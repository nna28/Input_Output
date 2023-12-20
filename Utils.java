import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    
    /*
     * cmt.
     */
    public static String readContentFromFile(String path) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            return String.join(System.lineSeparator(), lines);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
     * cmt.
     */
    public static void writeContentToFile(String path, String content) {
        try {
            Files.write(Paths.get(path), content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * cmt.
     */
    public static void appendContentToFile(String path, String content) {
        try {
            Files.write(Paths.get(path), (content + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * cmt.
     */
    public static File findFileByName(String folderPath, String fileName) {
        try {
            List<File> files = Files.walk(Paths.get(folderPath))
                                    .filter(Files::isRegularFile)
                                    .map(Path::toFile)
                                    .filter(file -> file.getName().equals(fileName))
                                    .collect(Collectors.toList());
            if (!files.isEmpty()) {
                return files.get(0); 
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
