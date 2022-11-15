package htw.berlin.demo.webtech.service;

import htw.berlin.demo.webtech.api.Person;
import htw.berlin.demo.webtech.api.PersonManipulationRequest;
import htw.berlin.demo.webtech.persistance.PersonEntity;
import htw.berlin.demo.webtech.persistance.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        List<PersonEntity> persons = personRepository.findAll();
        return persons.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Person findById(Long id) {
        var personEntity = personRepository.findById(id);
        return personEntity.map(this::transformEntity).orElse(null);
    }

    public Person create(PersonManipulationRequest request) {
        var PersonEntity = new PersonEntity(request.getFirstName(), request.getLastName(), request.isVaccinated());
        htw.berlin.demo.webtech.persistance.PersonEntity personEntity = personRepository.save(PersonEntity);
        return transformEntity(personEntity);
    }


    public Person update(Long id, PersonManipulationRequest request) {
        var personEntityOptional = personRepository.findById(id);
        if (personEntityOptional.isEmpty()) {
            return null;
        }

        var personEntity = personEntityOptional.get();
        personEntity.setFirstName(request.getFirstName());
        personEntity.setLastName(request.getLastName());
        personEntity.setVaccinated(request.isVaccinated());
        personEntity = personRepository.save(personEntity);

        return transformEntity(personEntity);
    }


    public boolean deleteById(Long id) {
        if (!personRepository.existsById(id)) {
            return false;
        }

        personRepository.deleteById(id);
        return true;
    }


    private Person transformEntity(PersonEntity personEntity) {
        return new Person(
                    personEntity.getId(),
                    personEntity.getFirstName(),
                    personEntity.getLastName(),
                    personEntity.isVaccinated()
            );
        }

}
