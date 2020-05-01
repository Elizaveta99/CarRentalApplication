package Model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserInfo.class)
public abstract class UserInfo_ {

	public static volatile SingularAttribute<UserInfo, String> number;
	public static volatile SingularAttribute<UserInfo, String> password;
	public static volatile SingularAttribute<UserInfo, String> name;
	public static volatile SingularAttribute<UserInfo, Integer> id;
	public static volatile SingularAttribute<UserInfo, String> login;
	public static volatile SingularAttribute<UserInfo, String> type;

	public static final String NUMBER = "number";
	public static final String PASSWORD = "password";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String LOGIN = "login";
	public static final String TYPE = "type";

}

