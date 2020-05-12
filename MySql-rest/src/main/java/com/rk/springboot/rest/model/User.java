package com.rk.springboot.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;
 
@Component
 
// Spring jpa jars.
@Entity
@Table(name= "user")
 
// To increase speed and save sql statement execution time.
@DynamicInsert
@DynamicUpdate
public class User {
 
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private String voice;
    private int mobile;
 
    public User() { }
 
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getVoice() {
        return voice;
    }
    public void setVoice(String voice) {
        this.voice = voice;
    }
    public int getMobile() {
        return mobile;
    }
    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
 
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", voice=" + voice + ", mobile=" + mobile + "]";
    }
}