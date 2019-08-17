package cn.zanezz.sys.service.impl;

import cn.zanezz.sys.service.PersonService;
import cn.zanezz.util.Util;
import cn.zanezz.sys.mapper.PersonMapper;
import cn.zanezz.sys.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("personService")
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonMapper personMapper;
    @Override
    public int insert(Person person) {
        return personMapper.insert(person);
    }

    @Override
    public Person getPersonByUserId(int userId) {
        return personMapper.getPersonByUserId(userId);
    }

    @Override
    public int updateByPrimaryKey(Person record) {
        return personMapper.updateByPrimaryKey(record);
    }

    @Override
    public boolean inputOfPerson(Person person) {
        Person oldPerson = personMapper.getPersonByUserId(person.getUserId());
        int flag1 = 0;
        int flag2 = 0;

        person.setUpdateTime(Util.getNowDateTime());
        if (oldPerson != null) {
            person.setPersonId(oldPerson.getPersonId());
            flag1 = personMapper.updateByPrimaryKeySelective(person);
        }else {
            person.setCreateTime(Util.getNowDateTime());
            flag2 =  personMapper.insert(person);
        }
        if (flag1 == 1 || flag2 == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<Person> selectAllPerson() {
        return personMapper.selectAllPerson();
    }

    @Override
    public List<Person> formatPageList(List<Person> personList, HashMap<String, String> dictionary) {
        for (Person person : personList) {
            person.setOperationYears(dictionary.get(person.getOperationYears()));
            person.setLocationOfCompany(dictionary.get(person.getLocationOfCompany()));
            person.setLicense(dictionary.get(person.getLicense()));
        }
        return personList;
    }

}
