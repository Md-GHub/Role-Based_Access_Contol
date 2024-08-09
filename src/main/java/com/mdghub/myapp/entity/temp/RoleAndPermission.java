//package com.mdghub.myapp.entity.temp;
//
//
//import com.mdghub.myapp.entity.UserRole;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToOne;
//
//@Entity
//public class RoleAndPermission {
//
//    @Id
//    @OneToOne
//    @JoinColumn(
//            referencedColumnName = "roleId"
//    )
//    private UserRole roleId;
//
//    @OneToOne
//    @JoinColumn(
//            referencedColumnName = "permissionId"
//    )
//    private Permission permissionId;
//
//    public RoleAndPermission() {
//    }
//
//    public RoleAndPermission(UserRole roleId, Permission permissionId) {
//        this.roleId = roleId;
//        this.permissionId = permissionId;
//    }
//
//    public UserRole getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(UserRole roleId) {
//        this.roleId = roleId;
//    }
//
//    public Permission getPermissionId() {
//        return permissionId;
//    }
//
//    public void setPermissionId(Permission permissionId) {
//        this.permissionId = permissionId;
//    }
//
//    @Override
//    public String toString() {
//        return "RoleAndPermission{" +
//                "roleId=" + roleId +
//                ", permissionId=" + permissionId +
//                '}';
//    }
//}
