package com.jsimao71.photos.web;

import java.security.Principal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.jsimao71.photos.config.PhotosConfiguration;
import org.einnovator.jpa.model.EntityBase2;
import org.einnovator.sso.client.manager.GroupManager;
import org.einnovator.sso.client.manager.RoleManager;
import org.einnovator.sso.client.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ControllerBase extends org.einnovator.common.web.ControllerBase {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    protected PhotosConfiguration config;

    @Autowired
    protected RoleManager roleManager;

    @Autowired
    protected UserManager userManager;

    @Autowired
    protected GroupManager groupManager;

    protected boolean can(Principal principal, boolean admin) {
        if (principal == null) {
            return false;
        }
        if (admin) {
            return isAdmin(principal);
        }
        return true;
    }

    protected boolean isAdmin(Principal principal) {
        return roleManager.isAdmin(principal);
    }

    protected boolean can(Principal principal, String user) {
        if (principal == null) {
            return false;
        }
        if (principal.getName().equals(user)) {
            return true;
        }
        if (isAdmin(principal)) {
            return true;
        }
        return false;
    }

    protected boolean canView(Principal principal, EntityBase2<?> obj) {
        if (can(principal, obj)) {
            return true;
        }
        return false;
    }

    protected boolean canManage(Principal principal, EntityBase2<?> obj) {
        if (can(principal, obj)) {
            return true;
        }
        return false;
    }

    protected boolean canCreate(Principal principal, EntityBase2<?> obj) {
        if (can(principal, obj)) {
            return true;
        }
        // permissive
        return true;
    }

    protected boolean can(Principal principal, EntityBase2<?> obj) {
        if (can(principal, obj.getCreatedBy())) {
            return true;
        }
        // permissive
        return true;
    }
}
