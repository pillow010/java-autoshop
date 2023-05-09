package com.automotoshop;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

/**

 User entity class used to represent a user in the application.

 Annotated with @Entity to mark it as a JPA entity and @Table to specify the table name.

 Uses Lombok annotations @Getter, @Setter, @ToString, and @RequiredArgsConstructor to automatically generate getter, setter,

 toString, and constructor with all required arguments.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class User {

    /**

     Id of the user.
     Annotated with @Id to specify it as the primary key, @GeneratedValue to indicate that the value of the field is
     automatically generated, and @Column to specify the column details.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     Username of the user.
     Annotated with @Column to specify the column details.
     */
    @Column(nullable = false, unique = true)
    private String username;

    /**
     Password of the user.
     Annotated with @Column to specify the column details.
     */
    @Column(nullable = false)
    private String password;

    /**
     Overrides equals() method to compare objects based on their ID fields.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass (this) != Hibernate.getClass (o)) return false;
        User user = (User) o;
        return getId () != null && Objects.equals (getId (), user.getId ());
    }

    /**
     Overrides hashCode() method to compute hash based on the class.
     */
    @Override
    public int hashCode() {
        return getClass ().hashCode ();
    }
}

