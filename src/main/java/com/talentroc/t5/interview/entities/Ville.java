package com.talentroc.t5.interview.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NamedQueries({@NamedQuery(name = Ville.RETRIEVE_ALL, query = "SELECT c FROM Ville c")})
public class Ville implements Serializable {
    public static final String RETRIEVE_ALL = "Ville.retrieveALl";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50)
    private String name;

    public Ville() {
    }

    public Ville(final String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        if (id == null) {
            return Objects.hash(name);
        } else {
            return Objects.hashCode(id);
        }
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Ville other = (Ville) obj;
        if (id == null) {
            return Objects.equals(this.name, other.name);
        } else {
            return Objects.equals(this.id, other.id);
        }
    }
}
