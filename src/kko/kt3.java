package kko;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class kt3 {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String filename;
        filename = "C://eclipse-workspace/algotithm-practice/access_log_00.txt";// scan.nextLine();
        // System.out.println(filename);
        List<String> list = new ArrayList<>();

        String str = "unicomp6.unicomp.net - - [01/Jul/1995:00:00:14 -0400] \"GET /images/NASA-logosmall.gif HTTP/1.0\" 200 786";

        Pattern pattern;
        Matcher matcher;
        // String patternStr1 = ".*([0-9]{2,4})[^0-9]([0-9]{1,2})[^0-9]([0-9]{1,2}).*";
        String patternStr = "(^[\\w.]+) - - (\\[[\\w:/]+\\s[+\\-]\\d{4}\\]) (\"(\\w.+) (/\\w.+)/(\\w.+[gif|GIF]) (\\w.+)\") (\\d+) (\\d+)";
        //String patternStr = "(^[\\w.]+) - - \\[([\\w:/]+\\s[+\\-]\\d{4})\\]";
        // (\\w+) (\\w+.*)
        pattern = Pattern.compile(patternStr);
        matcher = pattern.matcher(str);

        System.out.println(str);
        if (matcher.matches()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println(matcher.group(i));
            }
        }

        try (java.util.stream.Stream<String> stream = java.nio.file.Files.lines(java.nio.file.Paths.get(filename))) {
            list = stream.filter(line -> line.contains("gif") || line.contains("GIF")).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // list.forEach(line -> System.out.println(line));
        // Files.write(Paths.get("C://eclipse-workspace/algotithm-practice/gifs_access_log_00.txt"),list);
    }

}
