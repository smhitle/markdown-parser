import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MyMarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
	// added new line
        ArrayList<String> toReturn = new ArrayList<>();
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
        Path fileName = Path.of(args[0]);
        System.out.println(fileName.toAbsolutePath());
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
