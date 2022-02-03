package com.carmel.wcampaigner.service;

import com.carmel.wcampaigner.entity.ContactEntity;
import com.carmel.wcampaigner.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IContactService implements ContactService{

    @Autowired
    ContactRepository contactRepository;

    @Override
    public ContactEntity save(ContactEntity entity) {
        contactRepository.save(entity);
        return null;
    }
}
