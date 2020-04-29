package Model;

import Model.Exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

/**
 * DAO level for requests to Client entity
 */
public class JpaDAOClient extends JpaDAO implements DAOClient {
    static final Logger logger = LogManager.getLogger("dao");

//    @PersistenceContext(unitName="CarRental")
//    private EntityManager entityManager;

    /**
     * Returns client by given id
     * @param idPassport
     * @return boolean - is client exists
     */
    public Client getClientById(String idPassport) throws DAOException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Client client = new Client();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> q = cb.createQuery(Client.class);
        Root<Client> c = q.from(Client.class);
        ParameterExpression<String> pId = cb.parameter(String.class);
        q.select(c).where(cb.equal(c.get("idPassport"), pId));
        TypedQuery<Client> query = entityManager.createQuery(q);
        query.setParameter(pId, idPassport);
        client = query.getSingleResult();

        logger.info("Returned client by id successfully.");
        entityManager.close();
        return  client;
    }

}

