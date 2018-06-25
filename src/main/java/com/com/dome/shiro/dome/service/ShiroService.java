package com.com.dome.shiro.dome.service;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Service;

@Service
public class ShiroService {
    @RequiresRoles("admin")
    public void adminService(){
        System.out.println("role:admin");
    }

    @RequiresRoles("user")
    public void userService(){
        System.out.println("role:user");
    }

    @RequiresPermissions("blogEntry:edit")
    public void permissionService(){
        System.out.println("Permissions=blogEntry:edit");
    }

    @RequiresAuthentication
    public void authenticationService(){
        System.out.println("Permissions=blogEntry:edit");
    }



}
