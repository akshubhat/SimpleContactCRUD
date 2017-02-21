package com.travis.contact.dao;

import java.util.List;

import com.travis.contact.model.Contact;


public interface ContactDao {
    public List<Contact> getAllContact();
    public Contact getContactById(int contactId);
    public boolean insertNewContact(Contact contact);
    public boolean updateContact(Contact contact);
    public boolean deteleContact(int contactId);
}

