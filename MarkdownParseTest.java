import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1+1);
    }

    @Test
    public void testGetLinks() throws IOException{
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(content);
        List<String> list = List.of("https://something.com","some-thing.html");
        assertEquals(list, links);
    }

    @Test
    public void snippet1GetLinks() throws IOException {
        Path fileName = Path.of("snippet1.md");
        String content = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(content);
        List<String> list = List.of("`google.com","google.com", "ucsd.edu");
        assertEquals(list, links);
    }

    @Test
    public void snippet2GetLinks() throws IOException {
        Path fileName = Path.of("snippet2.md");
        String content = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(content);
        List<String> list = List.of("a.com","a.com(())", "example.com");
        assertEquals(list, links);
    }

    @Test
    public void snippet3GetLinks() throws IOException {
        Path fileName = Path.of("snippet3.md");
        String content = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(content);
        List<String> list = List.of("https://www.twitter.com","https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule", "https://cse.ucsd.edu/");
        assertEquals(list, links);
    }

}


