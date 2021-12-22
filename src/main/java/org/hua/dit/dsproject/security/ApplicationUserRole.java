package org.hua.dit.dsproject.security;

import java.util.Set;
import com.google.common.collect.Sets;
import static org.hua.dit.dsproject.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    CITIZEN(Sets.newHashSet(PET_READ, PET_WRITE)),
    ADMIN(Sets.newHashSet(PET_READ, PET_WRITE, CITIZEN_READ, CITIZEN_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions(){
        return permissions;
    }
}
