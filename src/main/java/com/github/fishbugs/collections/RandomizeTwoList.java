package com.github.fishbugs.collections;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 已知我们有两个List，fileList和imgList是一一对应的，
 * 现在希望让它们两个都随机排序，但是排序完要求它们依旧保持一一对应，
 * 这该怎么做呢？
 *
 * https://stackoverflow.com/questions/4228975
 */
public class RandomizeTwoList {
    public static String [] file = {"H1.txt","H2.txt","H3.txt","M4.txt","M5.txt","M6.txt"};
    public static ArrayList<String> fileList = new ArrayList<String>(Arrays.asList(file));

    public static String [] img = {"e1.jpg","e2.jpg","e3.jpg","e4.jpg","e5.jpg","e6.jpg"};
    public static ArrayList<String> imgList = new ArrayList<String>(Arrays.asList(img));
}
