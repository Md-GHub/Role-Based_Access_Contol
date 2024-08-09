package com.mdghub.myapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Resource {

    @Id
    private Long resourceId;
    private String resourceName;
    private String resourceType;
    private String resourceDescription;
    private String path;

    public Resource() {
    }

    public Resource(String resourceName, String resourceType, String resourceDescription, String path) {
        this.resourceName = resourceName;
        this.resourceType = resourceType;
        this.resourceDescription = resourceDescription;
        this.path = path;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceDescription() {
        return resourceDescription;
    }

    public void setResourceDescription(String resourceDescription) {
        this.resourceDescription = resourceDescription;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

