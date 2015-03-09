package com.talentroc.t5.interview.pages.contact;


import com.talentroc.t5.interview.entities.Contact;
import org.apache.tapestry5.annotations.Property;

public class ContactEdit {

    @Property
    private Contact contact;

    void onActivate() {
        contact = new Contact();
    }

    Boolean onActivate(Contact contact) {
        this.contact = contact;
        return Boolean.TRUE;
    }
}
