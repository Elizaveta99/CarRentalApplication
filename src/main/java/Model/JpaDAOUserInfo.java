package Model;

import Model.Exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaDAOUserInfo extends JpaDAO implements DAOUserInfo
{
    static final Logger logger = LogManager.getLogger("dao");

//    @PersistenceContext(unitName="CarRental")
//    private EntityManager entityManager;

    // save user in database - persist in DAO

    public UserInfo getUser(String login, String password, String type)  throws DAOException
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserInfo> q = cb.createQuery(UserInfo.class);
        Root<UserInfo> c = q.from(UserInfo.class);
        ParameterExpression<String> pLogin = cb.parameter(String.class);
        ParameterExpression<String> pPassword = cb.parameter(String.class);
        ParameterExpression<String> pType = cb.parameter(String.class);
        q.select(c).where(cb.equal(c.get("login"), pLogin),
                (cb.equal(c.get("password"), pPassword)),
                (cb.equal(c.get("type"), pType)));
        TypedQuery<UserInfo> query = entityManager.createQuery(q);
        query.setParameter(pLogin, login).setParameter(pPassword, password).setParameter(pType, type);
        UserInfo user = null;
        try {
            user = query.getSingleResult();
        } catch (NoResultException e)
        {
            throw new DAOException("This user doesn't exist");
        }

        //System.out.println("User: " + user);
        logger.info("User: " + user);
        entityManager.close();

        return user;
    }
}
