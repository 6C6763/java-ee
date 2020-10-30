package com.gc.stream;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author 6c6763
 * @date 2020/10/29
 */
public class StreamAction {

    public static void main(String[] args) {
        String[] strings = new String[]{"g", "o", "p", "h", "e", "r"};
        String str = "gopher";
        list(strings);
        System.out.println(Integer.parseInt("10"));
        System.out.println(Integer.valueOf("10"));
        change('c');
    }

    static void list(String... strings) {
        Stream.of(strings).forEach(
                System.out::println
        );
    }


    private static void change(char c) {
        if(c>='A' && c<='Z'){
            c+=32;
            System.out.println(c);
        }else if(c>='a' && c<='z'){
            c-=32;
            System.out.println(c);
        }


    }
}
