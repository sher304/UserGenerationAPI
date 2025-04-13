package org.example.usergenerationapi;

import net.datafaker.Faker;
import org.apache.catalina.User;
import org.example.usergenerationapi.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class FakeDataService {

    private Faker faker;

    @Autowired
    public FakeDataService(Faker faker) {
        this.faker = faker;
    }

    public List<Person> generateUsers(String entityNumber, String language, boolean fieldsRequired) {
        System.out.println(entityNumber + " " + language + " " + fieldsRequired);
        Faker localizedFaker = new Faker(new Locale(language));
        List<Person> people = new ArrayList<>();

        if (fieldsRequired) {
            for (int i = 0; i < Integer.valueOf(entityNumber); i++) {
                String firstName = localizedFaker.name().firstName();
                String lastName = localizedFaker.name().lastName();
                Person person = new Person(firstName, lastName);
                person.setEmail(localizedFaker.internet().emailAddress());
                person.setAddress(localizedFaker.address().fullAddress());
                person.setCompany(localizedFaker.company().name());
                person.setCountry(localizedFaker.country().name());
                person.setFavBook(localizedFaker.book().title());
                person.setFavCoffee(localizedFaker.coffee().name1());
                person.setGender(localizedFaker.gender().toString());
                person.setPet(localizedFaker.animal().name());
                person.setTransport(localizedFaker.transport().type());
                person.setUniversity(localizedFaker.university().name());
                people.add(person);
            }
        } else {
            for (int i = 0; i < Integer.valueOf(entityNumber); i++) {
                String firstName = localizedFaker.name().firstName();
                String lastName = localizedFaker.name().lastName();
                Person person = new Person(firstName, lastName);
                people.add(person);
            }
        }

        return people;
    }

}
