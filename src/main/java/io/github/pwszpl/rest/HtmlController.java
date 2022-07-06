package io.github.pwszpl.rest;

import io.github.pwszpl.mongo.collections.TestCollection;
import io.github.pwszpl.mongo.repositories.TestCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;

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

    @PostMapping("/find")
    public String search(Model model, @RequestBody(required=false) String query) {
        if(query != null){
            model.addAttribute("comments",repository.executeSearchQuery(query));
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
