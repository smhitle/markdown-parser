import static org.junit.Assert.*;
import org.junit.*;

import java.nio.file.Path;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;

public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1+1);
    }

    @Test
    public void testGetLinks() throws IOException{
        List<String> list = List.of("https://something.com", "some-thing.html");
        try {
            Path fileName = Path.of("test-file.md"); 
            String content = Files.readString(fileName);
            ArrayList<String> links = MarkdownParse.getLinks(content);
            assertEquals(list, links);
        } catch (NoSuchFileException e) {
            
        }
    }
}

