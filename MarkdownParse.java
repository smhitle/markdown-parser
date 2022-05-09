import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        String[] fileSubstrings = markdown.split("\n");
        String curSubstring;
        
        while(currentIndex < markdown.length()) {
            for (int i = 0; i < fileSubstrings.length; i++) {
                curSubstring = fileSubstrings[i];
                if (curSubstring.contains("[") && curSubstring.contains("]") && curSubstring.contains("(") && curSubstring.contains(")")) {
                    int openBracket = markdown.indexOf("[", currentIndex);
                    int closeBracket = markdown.indexOf("]", openBracket);
                    int openParen = markdown.indexOf("(", closeBracket);
                    int closeParen = markdown.indexOf(")", openParen);
                    if (!curSubstring.contains(" ")) {
                        toReturn.add(markdown.substring(openParen + 1, closeParen));
                    }
                    currentIndex = closeParen + 1;
                }
            }
            break;
        }
        return toReturn;
    }


    public static void main(String[] args) throws IOException{
        // Path fileName = Path.of(args[0]);
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
