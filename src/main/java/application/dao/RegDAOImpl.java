package application.dao;

import application.entity.BankSeek;
import application.entity.Reg;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegDAOImpl implements RegDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Reg> getRegList() {
        Session session = sessionFactory.getCurrentSession();
        Query<Reg> regQuery = session.createQuery("FROM Reg", Reg.class);
        return regQuery.getResultList();
    }
}
