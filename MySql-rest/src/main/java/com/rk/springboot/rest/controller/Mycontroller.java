package com.rk.springboot.rest.controller;

import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
import com.rk.springboot.rest.model.User;
import com.rk.springboot.rest.service.Myservice;
 
@RestController
public class Mycontroller {
 
    @Autowired
    Myservice service;
 
    @RequestMapping(value= "/user/all", method= RequestMethod.GET)
    public List<User> getUsers() {
        System.out.println(this.getClass().getSimpleName() + " - Get all users service is invoked.");
        return service.getUsers();
    }
 
    @RequestMapping(value= "/user/{id}", method= RequestMethod.GET)
    public User getUserById(@PathVariable int id) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - Get user details by id is invoked.");
 
        Optional<User> user =  service.getUserById(id);
        if(!user.isPresent())
            throw new Exception("Could not find user with id- " + id);
 
        return user.get();
    }
 
    @RequestMapping(value= "/user/add", method= RequestMethod.POST)
    public User createUser(@RequestBody User newuser) {
        System.out.println(this.getClass().getSimpleName() + " - Create new user method is invoked.");
        return service.addNewUser(newuser);
    }
 
    @RequestMapping(value= "/user/update/{id}", method= RequestMethod.PUT)
    public User updateUser(@RequestBody User upduser, @PathVariable int id) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - Update user details by id is invoked.");
 
        Optional<User> user =  service.getUserById(id);
        if (!user.isPresent())
            throw new Exception("Could not find user with id- " + id);
 
        /* IMPORTANT - To prevent the overriding of the existing value of the variables in the database, 
         * if that variable is not coming in the @RequestBody annotation object. */    
        if(upduser.getName() == null || upduser.getName().isEmpty())
            upduser.setName(user.get().getName());
        if(upduser.getVoice() == null || upduser.getVoice().isEmpty())
            upduser.setVoice(user.get().getVoice());
        if(upduser.getMobile() == 0)
            upduser.setMobile(user.get().getMobile());
 
        // Required for the "where" clause in the sql query template.
        upduser.setId(id);
        return service.updateUser(upduser);
    }
 
    @RequestMapping(value= "/user/delete/{id}", method= RequestMethod.DELETE)
    public void deleteUserById(@PathVariable int id) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - Delete user by id is invoked.");
 
        Optional<User> user =  service.getUserById(id);
        if(!user.isPresent())
            throw new Exception("Could not find user with id- " + id);
 
        service.deleteUserById(id);
    }
 
    @RequestMapping(value= "/users/deleteall", method= RequestMethod.DELETE)
    public void deleteAll() {
        System.out.println(this.getClass().getSimpleName() + " - Delete all users is invoked.");
        service.deleteAllUsers();
    }
}