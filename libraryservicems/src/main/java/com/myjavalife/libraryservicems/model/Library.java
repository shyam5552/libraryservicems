package com.myjavalife.libraryservicems.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Library {
    @Id
    int lib_id;

    @Column
    String username;
    @Column
    int book_id;

}
