package com.convscanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String nickName1 = "Aleksey Zhukov";
        String nickName2 = "Дениз";
        String message = "Aleksey Zhukov, [31.05.17 20:26]\n" +
                "только балконные\n" +
                "\n" +
                "Дениз, [31.05.17 20:26]\n" +
                "Ааа\n" +
                "\n" +
                "Дениз, [31.05.17 20:26]\n" +
                "Поняла\n" +
                "\n" +
                "Aleksey Zhukov, [31.05.17 20:26]\n" +
                "в плане они на кухню занесли)\n" +
                "\n" +
                "Дениз, [31.05.17 20:26]\n" +
                "Надеюсь я завтра не буду трупом";
        messegeScanner(message, nickName1, nickName2);
    }

    public static void messegeScanner(String message, String nickName1, String nickName2) {
        String regexp =  "("+nickName1+").{2}\\[.*]" + "(.*)" + "("+nickName2+").{2}\\[.*]";
        Pattern p = Pattern.compile(regexp, Pattern.DOTALL);
        Matcher m = p.matcher(message);
        while (m.find()) {
                System.out.println((m.group(2)));
//            System.out.println((m.group(1)));
//            System.out.println((m.group(2)));
//            System.out.println((m.group(3)));
        }
    }
}