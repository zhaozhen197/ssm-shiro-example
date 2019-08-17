package cn.zanezz.sys.mapper;

import cn.zanezz.sys.service.DictionaryService;
import cn.zanezz.sys.service.UserService;
import cn.zanezz.sys.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DictionaryMapperTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Autowired
    private DictionaryService dictionaryService;



    @Test
    public void test() throws ParseException {

        List<Map<String, String>> list = dictionaryService.selectAllDictionaryHashMap();
        Map<String, String> resultMap = new HashMap();
        for (Map<String, String> hashMap : list) {
           String  key = hashMap.get("value");
            System.out.println(key);
            resultMap.put(hashMap.get("key"), hashMap.get("value"));
        }
        System.out.println(list);

    }


    @Test
    public void testForamt() {
        List<User> allUser = userService.selectAllUser();
        Map<String, String> dictionary = dictionaryService.formatToDictionary(dictionaryService.selectAllDictionaryHashMap());
        List<User> userList = userService.formatPageList(allUser, (HashMap<String, String>) dictionary);
        System.out.println(userList);

    }



}
