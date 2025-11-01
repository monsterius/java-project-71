package hexlet.code.Utils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Reader {
    public static String readFile(String file) throws IOException {
        Path abspath = Paths.get(file).toAbsolutePath().normalize();
        return Files.readString(abspath);
    }
}
