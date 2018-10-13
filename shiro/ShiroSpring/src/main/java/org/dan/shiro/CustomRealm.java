package org.dan.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.dan.shiro.entity.User;

public class CustomRealm extends AuthorizingRealm {

	@Override
	public void setName(String name) {
		super.setName("customRealm");
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	// realm的认证方法，从数据库查询用户信息
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//token是用户输入的
		//第一步：从token中取出身份信息
		String usercode = (String) token.getPrincipal();
		
		//第二步：根据用户输入的usercode从数据库查询
		
		
		return null;
	}

}
