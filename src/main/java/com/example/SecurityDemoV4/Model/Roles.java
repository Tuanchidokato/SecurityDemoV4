package com.example.SecurityDemoV4.Model;

import javax.persistence.*;

@Entity
@Table(name = "tblRole")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERoles roleName;

    public Roles() {
    }

    public Roles(ERoles roleName) {
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERoles getRoleName() {
        return roleName;
    }

    public void setRoleName(ERoles roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", roleName=" + roleName +
                '}';
    }
}
