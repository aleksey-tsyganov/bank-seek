package application.dao;


import application.entity.Tnp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TnpDAOImpl implements TnpDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Tnp> getTnpList() {
        Session session = sessionFactory.getCurrentSession();
        Query<Tnp> tnpQuery = session.createQuery("FROM Tnp", Tnp.class);
        return tnpQuery.getResultList();
    }
}
