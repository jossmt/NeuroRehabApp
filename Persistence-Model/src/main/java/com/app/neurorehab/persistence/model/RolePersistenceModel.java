package com.app.neurorehab.persistence.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@Table(name = "Role")
public class RolePersistenceModel {

    /** Identifier. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Name. */
    @Column(name = "role")
    private String name;

    /**
     * Return identifier.
     *
     * @return id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Get name.
     *
     * @return user name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set name.
     *
     * @param name
     *         user name.
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Sets new Identifier..
     *
     * @param id
     *         New value of Identifier..
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        RolePersistenceModel that = (RolePersistenceModel) o;

        return new EqualsBuilder()
                .append(getName(), that.getName())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getName())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .toString();
    }
}
