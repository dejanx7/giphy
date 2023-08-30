package com.example.giphyspring.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.giphyspring.Service.GiphyService;

import jakarta.json.Json;



@RestController
@RequestMapping
@CrossOrigin    
public class GiphyController {

    @Autowired
    GiphyService service;

    @GetMapping(path = "/search" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getgif(@RequestParam String name, Integer limit, Integer offset){ 
        
        List<String> images = service.getGif(name, limit, offset);

        return ResponseEntity.ok(Json.createArrayBuilder(images).build().toString());

    }
    
}
