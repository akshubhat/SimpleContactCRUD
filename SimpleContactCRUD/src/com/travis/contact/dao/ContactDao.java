package com.travis.contact.dao;

import java.util.List;

import com.travis.contact.model.Contact;


public interface ContactDao {
    public List<Contact> getAllContact();
    public Contact getContactById(int contactId);
    public void insertNewContact(Contact contact);
    public void updateContact(Contact contact);
    public void deteleContact(Contact contact);
}

