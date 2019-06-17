package cn.xiaowei.utils;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Description: 加密密码工具类
 * @author: winkxiao
 * @date: 2019/3/28 15:51
 */
public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCEncoder = new BCryptPasswordEncoder();

    public static String encoding(String password){
        // 加密密码
        String pwd = bCEncoder.encode(password);

        return pwd;
    }

    /*public static void main(String[] args) {
        String encoding = encoding("123");
        System.out.println(encoding);
    }*/
}
