package io.ezstudy.open.csq.model;

import io.ezstudy.open.csq.Role;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name="user")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(columnDefinition = "VARCHAR(36)", insertable = false, updatable = false, nullable = false)
    private String id;

    private String name;
    private String email;
    private String gender;
    private String provider;

    @Enumerated(EnumType.STRING)
    private Role role;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Timestamp deleted_at;

    @Builder
    public User(String id, String name, String email, String gender, String provider, Role role, Timestamp created_at, Timestamp updated_at, Timestamp deleted_at) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.provider = provider;
        this.role = role;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

}
