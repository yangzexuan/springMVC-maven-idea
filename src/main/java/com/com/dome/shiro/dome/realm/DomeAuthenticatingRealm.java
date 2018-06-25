package com.com.dome.shiro.dome.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;

public class DomeAuthenticatingRealm extends AuthorizingRealm {


    public void initCredentialsMatcher(){

    }

    /**
     * 认证
     * @param authtoken
     * @return 用户的信息，以及进行比对的密码
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authtoken) throws AuthenticationException {
        AuthenticationInfo info= null;
//                进行明码的密码校验
        info = mingmapassword(authtoken);
        return  info;
    }

    /**
     * 授权实现
     * @param principals
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Object primaryPrincipal = principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        HashSet<String> strings = new HashSet<String>();


        simpleAuthorizationInfo.addRole("user");
        //fine-grained instance level permission:
        simpleAuthorizationInfo.addStringPermission("printer:print"); //allowed to 'print' to the 'printer' identified

        if("admin".equals(primaryPrincipal)){
            simpleAuthorizationInfo.addRole("admin");
            simpleAuthorizationInfo.addStringPermission("blogEntry:edit"); //this user is allowed to 'edit' _any_ blogEntry
        }







//        SimpleAccount account = new SimpleAccount(primaryPrincipal, "sha256EncodedPasswordFromDatabase", getName());
//        //simulate some roles and permissions:
//        account.addRole("user");
//       if("admin".equals(primaryPrincipal)){
//           account.addRole("admin");
//        }
//
//        account.addStringPermission("blogEntry:edit"); //this user is allowed to 'edit' _any_ blogEntry
//        //fine-grained instance level permission:
//        account.addStringPermission("printer:print:laserjet2000"); //allowed to 'print' to the 'printer' identified




        return simpleAuthorizationInfo;
    }

/************************************
 * 下面是私有方法
 ************************************/

    /**
     * 明码进行密码校验
     * @param authtoken
     * @return
     */
    private AuthenticationInfo mingmapassword(AuthenticationToken authtoken) throws AuthenticationException{

        UsernamePasswordToken token = (UsernamePasswordToken) authtoken;
        String usermsg = token.getUsername();

        final char[] password = token.getPassword();
        String pwd = new String(password);

        pwd  = "123";


        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(usermsg,pwd,this.getName());


        return info;
    }
}
