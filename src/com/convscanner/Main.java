package com.convscanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String nickName = "Aleksey Zhukov";
        messegeScanner("Aleksey Zhukov, [26.03.17 20:52] " +
        "Привет, да у меня всё нормально, неделя немного утомительная была, много чего по работе надо было делать" +
        " Aleksey Zhukov, [26.03.17 20:52] " +
        "Как-нибудь к тебе заеду Aleksey Zhukov", nickName);
    }

    public static boolean test(String testString) {
        Pattern p = Pattern.compile(".+|^(Aleksey Zhukov, \\[).+");
        Matcher m = p.matcher(testString);
        return m.matches();
    }

    public static void messegeScanner(String message, String nickName) {
        Pattern p = Pattern.compile("(Aleksey Zhukov).+(\\1)");
        Matcher m = p.matcher(message);
        if (m.find()) {
            //System.out.println((m.group()));
            System.out.println(m.group().substring(nickName.length()+ 19, m.group().length()- nickName.length()));
        }
        else System.out.println("error");
    }
}