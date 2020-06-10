package application.dao;

import application.entity.Pzn;
import application.entity.Uer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UerDAOImpl implements UerDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Uer> getUerList() {
        Session session = sessionFactory.getCurrentSession();
        Query<Uer> uerQuery = session.createQuery("FROM Uer", Uer.class);
        return uerQuery.getResultList();
    }
}
