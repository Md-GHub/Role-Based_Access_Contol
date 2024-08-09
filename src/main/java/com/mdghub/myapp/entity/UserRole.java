package com.mdghub.myapp.entity;


import jakarta.persistence.*;

@Entity
public class UserRole {

    @Id
    @SequenceGenerator(
            name = "roleIdSequence",
            sequenceName = "roleIdSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "roleIdSequence"
    )
    @Column(
            name = "role_id"
    )
    private Long roleId;

    @Column(
            name = "role_name",
            unique = true,
            nullable = false
    )
    private String roleName;

    @Column(
            name = "role_description",
            nullable = false
    )
    private String roleDescription;

    public UserRole() {
    }

    public UserRole(String roleName, String roleDescription) {
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                '}';
    }
}
