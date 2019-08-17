package cn.zanezz.util;

/**
 * 请求平台获取数据并且对数据进行简单的处理
 */

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;

/**
 * Created by zane on 2017/4/10.
 */
public class HttpClientUtil {

    /**
     * 利用httpclient 发送 get请求
     */
    public String get() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String resultJsonObject = null;
        try {
            // 创建httpget.
            HttpGet httpget = new HttpGet(this.getProperties("appid.properties", "WebSiteUrl"));
            // 执行get请求.
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // 打印响应内容长度
                    resultJsonObject = EntityUtils.toString(entity);
                    resultJsonObject = URLDecoder.decode(resultJsonObject, "UTF-8");
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultJsonObject;
    }


    /**
     * 获取地址
     *
     * @param
     * @return
     */
    public String getProperties(String name, String keyWord) throws IOException {
        Properties prop = new Properties();
        String path = this.getClass().getResource("/").getPath();
        prop.load(new FileInputStream(path + File.separator + name));
        return prop.getProperty(keyWord);
    }
}
