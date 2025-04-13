package org.example.usergenerationapi;

import net.datafaker.Faker;
import org.example.usergenerationapi.Model.Person;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GenerationPage {

    Faker faker = new Faker();

    private final FakeDataService fakeDataService;

    public GenerationPage(FakeDataService fakeDataService) {
        this.fakeDataService = fakeDataService;
    }

    @GetMapping("/generation")
    public String generateForm() {
        return "generationPage";
    }

    @PostMapping("/generate")
    public String generated(@RequestParam(defaultValue = "1") String entityNumber,
                           @RequestParam(defaultValue = "English") String language,
                           @RequestParam(required = false) List<String> fields,
                            Model model){
        List<Person> personList = new ArrayList<>();
        if (fields == null) {
            personList = fakeDataService.generateUsers(entityNumber, language, false);
            System.out.println("SIZE: " + personList.size());
        } else {
            personList = fakeDataService.generateUsers(entityNumber, language, true);
        }
        model.addAttribute("personList", personList);
        return "userGeneratedPage.html";
    }
}
