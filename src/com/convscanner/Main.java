package com.convscanner;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        String nickName1 = "Aleksey Zhukov";
        String nickName2 = "Дениз";
        String FILE_NAME = "D:\\Programs\\Java\\Projects\\ConverstaionScanner\\log.txt";
        StringBuffer string = new StringBuffer();
        Files.lines(Paths.get(FILE_NAME), StandardCharsets.UTF_8).forEach(s -> string.append(s + " "));
//        string.toString().replaceAll(".{1}In reply to " + nickName2+ ".{1}", " ");
        string.toString().replaceAll("Photo", " ");
        System.out.println(string.toString());
        messegeScanner(string.toString(), nickName1, nickName2);
//        System.out.println(message);

//        messegeScanner(message, nickName1, nickName2);
    }

    public static void messegeScanner(String message, String nickName1, String nickName2) {
        String regexp1 =  "("+nickName1+".{2}\\[.*\\])" + "(.*?)" + "("+nickName2+".{2}\\[.*\\])";
        String regexp = "("+nickName1+".{18})(.*?)"+"("+nickName2+".{18})";
        Pattern p = Pattern.compile(regexp, Pattern.DOTALL);
        Matcher m = p.matcher(message);
        while (m.find()) {
//                System.out.println(("Group 1 " + m.group(1)));
            System.out.println(("Group 2 " + m.group(2).replaceAll("\n", " ")
                    .replaceAll(nickName1+".{18}", "")));
//            System.out.println(("Group 3 " + m.group(3)));
//            System.out.println((m.group(3)));
        }
    }

    String message = "Дениз, [03.06.17 11:40]\n" +
            "А не из дома\n" +
            "\n" +
            "Aleksey Zhukov, [03.06.17 11:40]\n" +
            "ну уже у нее?\n" +
            "\n" +
            "Дениз, [03.06.17 11:41]\n" +
            "У нее)\n" +
            "\n" +
            "Aleksey Zhukov, [03.06.17 11:59]\n" +
            "Деееенкааа\n" +
            "\n" +
            "Aleksey Zhukov, [03.06.17 11:59]\n" +
            "че там, какие прогнозы? мне уже скучно дома становится :)\n" +
            "\n" +
            "Дениз, [03.06.17 11:59]\n" +
            "На что прогнозы?)\n" +
            "\n" +
            "Aleksey Zhukov, [03.06.17 11:59]\n" +
            "так смешно звучит - Дэнка ;)\n" +
            "\n" +
            "Aleksey Zhukov, [03.06.17 11:59]\n" +
            "прогнозы, когда ты закончишь\n" +
            "\n" +
            "Дениз, [03.06.17 12:00]\n" +
            "Еще час";
}