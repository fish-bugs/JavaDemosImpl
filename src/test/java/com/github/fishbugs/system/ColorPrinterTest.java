package com.github.fishbugs.system;

import org.junit.Test;

import static org.junit.Assert.*;

public class ColorPrinterTest {
    /**
     * 在控制台中打印彩色字体
     * 注意：
     *   window系统不生效
     *   部分linux shell也不支持
     */
    @Test
    public void print(){
        System.out.println(ColorPrinter.ANSI_RED + "This text is red!"
                + ColorPrinter.ANSI_RESET);

        System.out.println(ColorPrinter.ANSI_BLUE + "This text is blue!"
                + ColorPrinter.ANSI_RESET);
        System.out.println(ColorPrinter.ANSI_CYAN + "This text is cyan!"
                + ColorPrinter.ANSI_RESET);
    }
}