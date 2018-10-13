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

	// realm����֤�����������ݿ��ѯ�û���Ϣ
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//token���û������
		//��һ������token��ȡ�������Ϣ
		String usercode = (String) token.getPrincipal();
		
		//�ڶ����������û������usercode�����ݿ��ѯ
		
		
		return null;
	}

}
