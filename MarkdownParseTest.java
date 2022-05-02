import static org.junit.Assert.*;
import org.junit.*;

import java.nio.file.Path;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;

public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1+1);
    }

    @Test
    public void testGetLinks() throws IOException {
        List<String> list = List.of("https://something.com", "some-thing.html");
        Path fileName = Path.of("\\Users\\lienm\\Documents\\GitHub\\markdown-parser\\test-file.md"); 
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(list, links);
    }
}