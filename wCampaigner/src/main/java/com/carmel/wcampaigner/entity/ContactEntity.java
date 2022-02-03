package com.carmel.wcampaigner.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "WC_CONTACT")
public class ContactEntity {
    @Id
    @Column(name = "ID")
    @Size(max = 40)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "FULLNAME",columnDefinition = "varchar(255)")
    @Size(max = 255)
    private String fullname;

    @Column(name = "PHONEONE", columnDefinition = "varchar(10)")
    @Size(max = 10)
    private String phoneOne;

    @Column(name = "PHONETWO",columnDefinition = "varchar(10)")
    @Size(max = 10)
    private String phoneTwo;

    @Column(name = "PHONETHREE",columnDefinition = "varchar(10)")
    @Size(max = 10)
    private String phoneThree;

    public ContactEntity() {
    }

    public ContactEntity(String fullname, String phoneOne, String phoneTwo, String phoneThree) {
        this.fullname = fullname;
        this.phoneOne = phoneOne;
        this.phoneTwo = phoneTwo;
        this.phoneThree = phoneThree;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoneOne() {
        return phoneOne;
    }

    public void setPhoneOne(String phoneOne) {
        this.phoneOne = phoneOne;
    }

    public String getPhoneTwo() {
        return phoneTwo;
    }

    public void setPhoneTwo(String phoneTwo) {
        this.phoneTwo = phoneTwo;
    }

    public String getPhoneThree() {
        return phoneThree;
    }

    public void setPhoneThree(String phoneThree) {
        this.phoneThree = phoneThree;
    }
}
