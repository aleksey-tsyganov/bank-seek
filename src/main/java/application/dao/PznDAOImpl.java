package application.dao;

import application.entity.Pzn;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PznDAOImpl implements PznDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Pzn> getPznList() {
        Session session = sessionFactory.getCurrentSession();
        Query<Pzn> pznQuery = session.createQuery("FROM Pzn", Pzn.class);
        return pznQuery.getResultList();
    }
}
