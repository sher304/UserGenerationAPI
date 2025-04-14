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

    public List<Person> generateUsers(String entityNumber, String language, List<String> fieldsRequired) {
        Faker localizedFaker = new Faker(new Locale(language));
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < Integer.valueOf(entityNumber); i++) {
            if (fieldsRequired != null) {
                String firstName = localizedFaker.name().firstName();
                String lastName = localizedFaker.name().lastName();
                Person person = new Person(firstName, lastName);
                person.setBd(localizedFaker.date().birthday());
                if (fieldsRequired.contains("email")) {
                    person.setEmail(localizedFaker.internet().emailAddress());
                }
                if (fieldsRequired.contains("address")) {
                    person.setAddress(localizedFaker.address().fullAddress());
                }
                if (fieldsRequired.contains("company")) {
                    person.setCompany(localizedFaker.company().name());
                }
                if (fieldsRequired.contains("country")) {
                    person.setCountry(localizedFaker.country().name());
                }
                if (fieldsRequired.contains("book")) {
                    person.setFavBook(localizedFaker.book().title());
                }
                if (fieldsRequired.contains("coffee")) {
                    person.setFavCoffee(localizedFaker.coffee().name1());
                }
                if (fieldsRequired.contains("gender")) {
                    person.setGender(localizedFaker.demographic().sex());
                }
                if (fieldsRequired.contains("pet")) {
                    person.setPet(localizedFaker.animal().name());
                }
                if (fieldsRequired.contains("transport")) {
                    person.setTransport(localizedFaker.transport().type());
                }
                if (fieldsRequired.contains("university")) {
                    person.setUniversity(localizedFaker.university().name());
                }
                if (fieldsRequired.contains("job")) {
                    person.setJob(localizedFaker.job().title());
                }
                if (fieldsRequired.contains("phoneNumber")) {
                    person.setPhoneNumber(localizedFaker.phoneNumber().phoneNumber());
                }
                person.setLanguage(language);
                people.add(person);
            } else {
                String firstName = localizedFaker.name().firstName();
                String lastName = localizedFaker.name().lastName();
                Person person = new Person(firstName, lastName);
                person.setBd(localizedFaker.date().birthday());
                people.add(person);
            }
        }
        return people;
    };
}
