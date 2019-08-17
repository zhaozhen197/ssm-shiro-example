package cn.zanezz.sys.mapper;

import cn.zanezz.sys.entity.ReturnMessage;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleTest {
    public static void main(String[] args) {
        System.out.println((int)((Math.random()*9+1)*100000));
        ReturnMessage message = new ReturnMessage("sdwwdwwd", "adadwww");
        JSONObject jsonObject = JSONObject.fromObject(message);
        String jsonString = jsonObject.toString();
        System.out.println(jsonString);
        System.out.println(System.currentTimeMillis()/1000);
    }


    @Test
    public Date getNowDateTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Date returnDate = null;
        try {
            returnDate = simpleDateFormat.parse(simpleDateFormat.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return returnDate;
    }
}
