package com.gc.string;

/**
 * @author 6c6763
 * @date 2020/10/29
 */
public class StringAction {

    public static void main(String[] args) {
        strConcat();
    }
    static void strConcat(){
        String str="gopher";
        String lee = str.concat("lee");
        String s="lee";
        System.out.println(lee);
        System.out.println(str+s);
    }
}
