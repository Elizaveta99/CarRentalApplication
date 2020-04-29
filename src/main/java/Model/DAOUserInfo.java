package Model;

import Model.Exception.DAOException;

public interface DAOUserInfo extends DAO {
    UserInfo getUser(String login, String password, String type) throws DAOException;
}
