package team.community.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author TAN00XU
 */
public class StrUtil {
    /**
     * 字符串首字母大写
     *
     * @param fieldName
     * @return
     */
    public static String getMethodName(String fieldName) {
        char[] a = fieldName.toCharArray();
        int aAscii = (int) a[0];
        if (aAscii >= 97 && aAscii <= 122) {
            a[0] -= 32;
        }
        return String.valueOf(a);
    }

    /**
     * 是否不为空值
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return str != null && !"".equals(str);
    }

    /**
     * 是否为空值
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return !isNotEmpty(str);
    }

    /**
     * String字符串转换Integer
     * @param str
     * @return
     */
    public static int parseSteToInt(String str) {
        //判断字符串是否为空
        if (isEmpty(str)) {
            return -1;
        }
        try {
            int num = Integer.parseInt(str);
            return num;
        } catch (NumberFormatException e) {
            System.out.println("请输入合法的数值字符串");
        }
        return -1;
    }

    /**
     * 字符串拆分为数组
     * @param str
     * @param symbol
     * @return
     */
    public static List<Integer> parseStrToArray(String str, String symbol) {
        if (isEmpty(str) || isEmpty(symbol)) {
            return Collections.emptyList();
        }
        String[] strArray = str.split(symbol);
        //将集合数值转换为Stream流
        List<Integer> integerList = Arrays.stream(strArray)
                //数据过滤
                .filter(string -> isNotEmpty(string))
                //数据处理、类型转换
                .map(string -> parseSteToInt(string))
                //将stream流转换为需要的类型
                .collect(Collectors.toList());
        return integerList;

       /*
        int[] numArray = new int[strArray.length];

        for (int i = 0; i < strArray.length; i++) {
            String s = strArray[i];
            if (isEmpty(s)) {
                continue;
            }
            int num = Integer.parseInt(s);
            numArray[0] = num;
        }
        return numArray;
        */
    }


}


