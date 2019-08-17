package cn.zanezz.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {


    /**
     * 返回当前的格式化时间，以方便存入数据库
     * @return
     */
    public static Date getNowDateTime() {
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

    public static String formateTime(Date date) {
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);

    }
}
