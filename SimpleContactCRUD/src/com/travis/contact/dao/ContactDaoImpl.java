package com.travis.contact.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.travis.contact.model.Contact;
import com.travis.contact.utils.DBUtils;


public class ContactDaoImpl implements ContactDao	 {
    private final String SQL_GET_ALL_CONTACT = "SELECT * FROM contacts";
    private final String SQL_GET_CONTACT_BY_ID = "SELECT * FROM contacts WHERE contact_id=?";
    private final String SQL_INSERT_NEW_CONTACT = "INSERT INTO contacts(f_name,l_name,_email,address) VALUES(?,?,?,?)";
    private final String SQL_UPDATE_CONTACT = "UPDATE contacts SET f_name=?, l_name=?,email=?,address=? WHERE contact_id=?";
    private final String SQL_DELETE_CONTACT = "DELETE FROM contacts WHERE id=?";
    private static final Logger LOGGER = Logger.getLogger(ContactDaoImpl.class.getName());
    
    @Override
    public List<Contact> getAllContact() {
        List<Contact> contacts = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;

        try {
            connection = DBUtils.getConnection(connection);
            statement = connection.createStatement();
            result = statement.executeQuery(SQL_GET_ALL_CONTACT);
            
            while(result.next()) {
                Contact contact = new Contact();
                contact.setContactId(result.getInt("contact_id"));
                contact.setFirstName(result.getString("f_name"));
                contact.setLastName(result.getString("l_name"));
                contact.setEmail(result.getString("email"));
                contact.setAddress(result.getString("address"));
                contacts.add(contact);
            }
        } catch (SQLException err) {
            LOGGER.log(Level.FINER, err.toString());
        } finally {
            DBUtils.close(result);
            DBUtils.close(statement);
            DBUtils.close(connection);
        }
        
        return contacts;
    }

    @Override
    public Contact getContactById(int contactId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Contact contact = null;
        
        try {
        	connection = DBUtils.getConnection(connection);
        	statement = connection.prepareStatement(SQL_GET_CONTACT_BY_ID);
        	statement.setInt(1, contactId);
        	result = statement.executeQuery();
        	while (result.next()) {
        		contact = new Contact();
        		contact.setContactId(result.getInt("contact_id"));
                contact.setFirstName(result.getString("f_name"));
                contact.setLastName(result.getString("l_name"));
                contact.setEmail(result.getString("email"));
                contact.setAddress(result.getString("address"));
        	}
        } catch (SQLException err) {
        	LOGGER.log(Level.FINER, err.toString());
        } finally {
            DBUtils.close(result);
            DBUtils.close(statement);
            DBUtils.close(connection);
        }
    	
    	return contact;
    }

    @Override
    public void insertNewContact(Contact contact) {
       
    }

    @Override
    public void updateContact(Contact contact) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
        	connection = DBUtils.getConnection(connection);
        	statement = connection.prepareStatement(SQL_UPDATE_CONTACT);
        	statement.setString(1, contact.getFirstName());
        	statement.setString(2, contact.getLastName());
        	statement.setString(3, contact.getEmail());
        	statement.setString(4, contact.getAddress());
        	statement.setInt(5, contact.getContactId());
        	statement.executeUpdate();        	
        } catch(SQLException err) {
        	LOGGER.log(Level.FINER, err.toString());
        } finally {
            DBUtils.close(statement);
            DBUtils.close(connection);
        }
    }

    @Override
    public void deteleContact(Contact contact) {
       
    }
    
}