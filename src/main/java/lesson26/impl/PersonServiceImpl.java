package lesson26.impl;

import lesson18.dto.Person;
import lesson25.spring.dao.PersonDao;
import lesson26.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service // помечает бины, которые содержат логику работы с данными. Эта аннотация логичнее @Component
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    @Override
    public void save(Person person) {

    }
}
