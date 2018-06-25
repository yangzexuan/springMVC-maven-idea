package com.com.dome.shiro.dome;/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import com.com.dome.shiro.dome.realm.DomeAuthenticatingRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;


/**
 * Simple Quickstart application showing how to use Shiro's API.
 *
 * @since 0.9 RC2
 */
public class Quickstart {

    private static final transient Logger log = LoggerFactory.getLogger(Quickstart.class);


    public static void main(String[] args) {

        // The easiest way to create a Shiro SecurityManager with configured
        // realms, users, roles and permissions is to use the simple INI config.
        // We'll do that by using a factory that can ingest a .ini file and
        // return a SecurityManager instance:

        // Use the shiro.ini file at the root of the classpath
        // (file: and url: prefixes load from files and urls respectively):
        /*
        1、根据配置文件获取创建工厂
        2、根据工厂获取 manager
         */
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro/shiro.ini");
        DefaultSecurityManager securityManager = (DefaultSecurityManager) factory.getInstance();

//        securityManager
        Collection<Realm> realms = securityManager.getRealms();
//        realms.add(new DomeAuthenticatingRealm());

//        securityManager.setRealm(new DomeAuthenticatingRealm());

        // for this simple example quickstart, make the SecurityManager
        // accessible as a JVM singleton.  Most applications wouldn't do this
        // and instead rely on their container configuration or web.xml for
        // webapps.  That is outside the scope of this simple quickstart, so
        // we'll just do the bare minimum so you can continue to get a feel
        // for things.

        /*
        3、设置securityManager
         */
        SecurityUtils.setSecurityManager(securityManager);
//        securityManager.getAuthenticator

        // Now that a simple Shiro environment is set up, let's see what you can do:

        // get the currently executing user:
        /*
        4、获取Subject
         */
        Subject currentUser = SecurityUtils.getSubject();
        final Subject subject = SecurityUtils.getSubject();

        // Do some stuff with a Session (no need for a web or EJB container!!!)
        Session session = currentUser.getSession();
        session.setAttribute("someKey", "aValue");
        String value = (String) session.getAttribute("someKey");
        if (value.equals("aValue")) {
            log.debug("Retrieved the correct value! [" + value + "]");
        }

        // let's login the current user so we can check against roles and permissions:
        if (!currentUser.isAuthenticated()) {
//            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
            UsernamePasswordToken token = new UsernamePasswordToken("root", "secret");
            token.setRememberMe(true);
            try {
//                进行认证
                currentUser.login(token);
            } catch (UnknownAccountException uae) {

                log.error("There is no user with username of " + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {
                log.error("Password for account " + token.getPrincipal() + " was incorrect!");
            } catch (LockedAccountException lae) {
                log.error("The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            }
        }

    

        //say who they are:
        //print their identifying principal (in this case, a username):
        log.debug("User [" + currentUser.getPrincipal() + "] logged in successfully.");

        //test a role:
//        编程授权的核心
        if (currentUser.hasRole("schwartz")) {
            log.info("May the Schwartz be with you!");
        } else {
            log.error("Hello, mere mortal.");
        }

        //test a typed permission (not instance-level)
        if (currentUser.isPermitted("lightsaber:weild")) {
            log.info("You may use a lightsaber ring.  Use it wisely.");
        } else {
            log.error("Sorry, lightsaber rings are for schwartz masters only.");
        }

        //a (very powerful) Instance Level permission:
        if (currentUser.isPermitted("winnebago:drive:eagle5")) {
            log.info("You are permitted to 'drive' the winnebago with license plate (id) 'eagle5'.  " +
                    "Here are the keys - have fun!");
        } else {
            log.error("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
        }

        //all done - log out!
        currentUser.logout();

        System.exit(0);
    }
}
