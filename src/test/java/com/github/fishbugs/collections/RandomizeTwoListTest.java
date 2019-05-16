package com.github.fishbugs.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

import static com.github.fishbugs.collections.RandomizeTwoList.*;

/**
 * 这里我们使用了Collections.shuffle来随机排序，
 * 同时给一个一样的种子，保证它们按照同样的方式来排序
 */
public class RandomizeTwoListTest {
    /**
     * 这样乱序是不行的，因为结果失去了一一对应的关系
     */
    @Test
    public void wrongRandomize(){
        // 这个方法大致就是对传入和list一次for循环，
        //   然后每次和rand.nextInt 做一次位置调换
        //   来达到随机切换位置的效果
        Collections.shuffle(fileList);
        Collections.shuffle(imgList);

        System.out.println(fileList);
        System.out.println(imgList);

        // [H3.txt, M5.txt, H2.txt, H1.txt, M6.txt, M4.txt]
        // [e6.jpg, e3.jpg, e4.jpg, e1.jpg, e2.jpg, e5.jpg]
    }

    @Test
    public void randomTogether(){
        List<List<String>> compoundList = new ArrayList();
        for (int i = 0; i < fileList.size(); i++) {
            List<String> listItem = new ArrayList();
            listItem.add(fileList.get(i));
            listItem.add(imgList.get(i));
            compoundList.add(listItem);
        }

        System.out.println(compoundList);
        // [[H1.txt, e1.jpg], [H2.txt, e2.jpg], [H3.txt, e3.jpg], [M4.txt, e4.jpg], [M5.txt, e5.jpg], [M6.txt, e6.jpg]]

        Collections.shuffle(compoundList);

        System.out.println(compoundList);
        // [[M5.txt, e5.jpg], [H2.txt, e2.jpg], [M4.txt, e4.jpg], [H3.txt, e3.jpg], [H1.txt, e1.jpg], [M6.txt, e6.jpg]]

        for (int i = 0; i < fileList.size(); i++) {
            fileList.set(i, compoundList.get(i).get(0));
            imgList.set(i, compoundList.get(i).get(1));
        }

        System.out.println(fileList);
        // [M5.txt, H2.txt, M4.txt, H3.txt, H1.txt, M6.txt]

        System.out.println(imgList);
        // [e5.jpg, e2.jpg, e4.jpg, e3.jpg, e1.jpg, e6.jpg]
    }

    @Test
    public void randomize(){
        long seed = System.nanoTime();

        Random random = new Random(seed);
        Collections.shuffle(fileList, random);
        Collections.shuffle(imgList, random);

        System.out.println(fileList);
        System.out.println(imgList);

        // [M5.txt, M4.txt, H1.txt, H2.txt, H3.txt, M6.txt]
        // [e5.jpg, e4.jpg, e1.jpg, e2.jpg, e3.jpg, e6.jpg]
    }

    @Test
    public void randomize2(){
        long seed = System.nanoTime();

        // 这个方法大致就是对传入和list一次for循环，
        //   然后每次和rand.nextInt 做一次位置调换
        //   来达到随机切换位置的效果
        Collections.shuffle(fileList, new Random(seed));
        Collections.shuffle(imgList, new Random(seed));

        System.out.println(fileList);
        System.out.println(imgList);

        // [M5.txt, M4.txt, H1.txt, H2.txt, H3.txt, M6.txt]
        // [e5.jpg, e4.jpg, e1.jpg, e2.jpg, e3.jpg, e6.jpg]
    }

    /**
     * 返回当前的时间的纳秒的表示，类似于
     *    System.currentTimeMillis();
     * 但是后者粒度更大，不适合作为随机数种子
     */
    @Test
    public void nanoTime(){
        for (int i = 0; i < 20; i++) {
            System.out.println(System.nanoTime());
        }
        //    1135400442745909
        //    1135400442828927
        //    1135400442854880
        //    1135400442877509
        //    ....
    }

    /**
     * 只要随机数的种子一样，那么nextInt的值必然相等
     */
    @Test
    public void random(){
        for (int i = 0; i < 3; i++) {
            System.out.println(new Random(i).nextInt());
            System.out.println(new Random(i).nextInt());
        }
    }
}