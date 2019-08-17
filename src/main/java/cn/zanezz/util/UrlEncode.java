package cn.zanezz.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 将http地址进行编码
 * Created by zane on 2016/11/21.
 */
public class UrlEncode {
    public static String urlEncode(String url) throws UnsupportedEncodingException {
        String result = url;
        result = URLEncoder.encode(result, "UTF-8");
        return result;
    }
}
