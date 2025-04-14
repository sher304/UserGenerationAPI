package org.example.usergenerationapi;

import net.datafaker.Faker;
import org.example.usergenerationapi.Model.Person;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
    public String generated(@RequestParam String entityNumber,
                           @RequestParam("lang") String lang,
                           @RequestParam(required = false) List<String> fields,
                            Model model){

        if (entityNumber.equals("") || lang == null) {
            model.addAttribute("errorMessage", "Please enter a valid number of entries.");
            return "generationPage";
        }


        List<Person> personList = new ArrayList<>();
        personList = fakeDataService.generateUsers(entityNumber, lang, fields);
        model.addAttribute("personList", personList);
        return "userGeneratedPage.html";
    }
}
