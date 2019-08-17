package cn.zanezz.sys.service;

import cn.zanezz.sys.entity.Person;

import java.util.HashMap;
import java.util.List;

public interface PersonService {

    public int insert(Person person);


    public Person getPersonByUserId(int userId);


    public int updateByPrimaryKey(Person record);

    public boolean inputOfPerson(Person Person);

    List<Person> selectAllPerson();

    List<Person> formatPageList(List<Person> personList, HashMap<String, String> dictionary);


}
