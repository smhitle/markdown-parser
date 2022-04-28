import static org.junit.Assert.*;
import org.junit.*;

import java.nio.file.Path;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;

public class MarkdownParseTest {

    @Before 
    public void setUp(){
        Path fileName = Path.of("test-file.md");
    }


    @Test
    public void addition() {
        assertEquals(2, 1+1);
    }

    @Test
    public void testGetLinks() {
        List<String> list = List.of("https://something.com", "some-page.html");
        try {
            fileName ;
        } catch (IOException e) {
            //TODO: handle exception
        }
        fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
    }
}