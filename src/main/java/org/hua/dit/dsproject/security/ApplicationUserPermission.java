package org.hua.dit.dsproject.security;

public enum ApplicationUserPermission {
    CITIZEN_READ("citizen:read"),
    CITIZEN_WRITE("citizen:write"),
    PET_READ("pet:read"),
    PET_WRITE("pet:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
