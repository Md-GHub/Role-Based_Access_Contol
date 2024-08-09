package com.mdghub.myapp.entity;


import jakarta.persistence.*;

@Entity
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "permission_id",
            unique = true,
            nullable = false
    )
    private Long permissionId;

    @Column(
            name = "permission_name",
            unique = true,
            nullable = false
    )
    private String permissionName;

    @Column(
            name = "permission_description",
            nullable = false
    )
    private String permissionDesc;

    @ManyToOne
    @JoinColumn(
            name = "user_id"
    )
    private UserRole userRole;


    @ManyToOne
    @JoinColumn(
            name = "resource_id"
    )
    private Resource resource;


    public Permission() {
    }

    public Permission(String permissionName, String permissionDesc) {
        this.permissionName = permissionName;
        this.permissionDesc = permissionDesc;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionDesc() {
        return permissionDesc;
    }

    public void setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId=" + permissionId +
                ", permissionName='" + permissionName + '\'' +
                ", permissionDesc='" + permissionDesc + '\'' +
                '}';
    }
}
