package com.herval.search.controller;

import com.herval.search.component.SearchComponent;
import com.herval.search.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Criado Por Herval Mata em 30/08/2018
 */
@CrossOrigin
@RestController
@RequestMapping("/search")
public class SearchRestController {

    private SearchComponent searchComponent;

    @Autowired
    public SearchRestController(SearchComponent searchComponent) {
        this.searchComponent = searchComponent;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    List<Flight> search(@RequestBody SearchQuery query){
        System.out.println("Input : " + query);
        return searchComponent.search(query);
    }
}
