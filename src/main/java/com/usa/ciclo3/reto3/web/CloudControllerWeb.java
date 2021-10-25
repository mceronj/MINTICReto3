package com.usa.ciclo3.reto3.web;

import java.util.List;
import java.util.Optional;

import com.usa.ciclo3.reto3.model.Cloud;
import com.usa.ciclo3.reto3.services.CloudServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Cloud")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class CloudControllerWeb {

    @Autowired
    private CloudServices cloudServices;

    @GetMapping("/all")
    public List<Cloud> getCloud(){

        return cloudServices.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Cloud> getCloud (@PathVariable("id") int id) {

        return cloudServices.getCloud(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cloud save(@RequestBody Cloud cloud) {

        return cloudServices.save(cloud);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)

    public Cloud update(@RequestBody Cloud cloud) {

        return cloudServices.update(cloud);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return cloudServices.deleteCloud(id);
    }


}
