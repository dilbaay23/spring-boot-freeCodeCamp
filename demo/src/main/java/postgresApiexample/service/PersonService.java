package postgresApiexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import postgresApiexample.dao.PersonDao;
import postgresApiexample.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> selectAllPeople() {
        return personDao.selectAllPeople();
    }

    public Optional<Person> selectPersonById(UUID id) {
        return personDao.selectPersonById(id);

    }

    public int deletePersonByID(UUID id) {
        return personDao.deletePersonByID(id);
    }

    public int updatePersonById(UUID id, Person person) {
        return personDao.updatePersonById(id, person);
    }
}
