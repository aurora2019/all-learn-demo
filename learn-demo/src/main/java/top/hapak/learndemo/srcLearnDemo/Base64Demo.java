package top.hapak.learndemo.srcLearnDemo;

import com.sun.deploy.util.ArrayUtil;
import org.springframework.util.Base64Utils;

import java.util.Base64;

/**
 * @author aurora
 * @description 技术改变心态
 */
public class Base64Demo {
    public static void main(String[] args) {
        byte[] bytes = {1,23,4,5,6,9,8,2,2,16,1};
        String s1 = Base64Utils.encodeToString(bytes);
        byte[] s2 = Base64Utils.decodeFromString(s1);
        System.out.println(s2);
        System.out.println(s1);
        byte[] b2 = Base64Utils.encode(bytes);
        System.out.println(b2.toString());
        byte[] b3 = Base64Utils.decode(b2);
        System.out.println(b3.toString());
    }
}