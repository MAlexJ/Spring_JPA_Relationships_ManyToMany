package com.malex.model;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity implements Serializable {

//    ********************** POSRGRESQL ******************************
//    @Id
//    @SequenceGenerator(name = "store_sequence", sequenceName = "store_sequence", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_sequence")
//    ********************** POSRGRESQL ******************************

//    ********************** END: MYSQL ******************************
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    ********************** END: MYSQL ******************************
    private Long id;

    public BaseEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
