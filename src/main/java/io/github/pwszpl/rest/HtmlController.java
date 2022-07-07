package io.github.pwszpl.rest;

import io.github.pwszpl.mongo.collections.TestCollection;
import io.github.pwszpl.mongo.parser.ParseException;
import io.github.pwszpl.mongo.repositories.TestCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class HtmlController {
    @Autowired
    TestCollectionRepository repository;

    @RequestMapping({"/","/index.html","/index"})
    public String index(Model model) {
        model.addAttribute("comment", new TestCollection());
        model.addAttribute("comments",repository.findAll());
        return "index";
    }

    @RequestMapping({"/about.html","/about"})
    public String about(Model model) {
        return "about";
    }


    @PostMapping("/find")
    public String search(Model model, @RequestBody(required=false) String query) {
        if(query != null){
            try {
                model.addAttribute("comments",repository.executeSearchQuery(query));
            } catch (ParseException e) {
                model.addAttribute("searchError",e.getMessage());
                model.addAttribute("comments",new ArrayList<TestCollection>());
            }
        } else {
            model.addAttribute("comments",repository.findAll());
        }
        return "fragments/navbarSearchResult.html :: searchResult";
    }

    @PostMapping("/index.html")
    public String addComment(@ModelAttribute TestCollection comment, Model model){
        repository.insert(comment);
        return index(model);
    }
}
