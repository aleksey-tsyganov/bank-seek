package application.dao;

import application.entity.BankSeek;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankSeekDAOImpl implements BankSeekDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean validateBank (String keyword) {
        Session session = sessionFactory.getCurrentSession();
        Query<BankSeek> bankSeekQuery = session.createQuery("FROM BankSeek WHERE newnum=:keyword");
        bankSeekQuery.setParameter("keyword", keyword);
        return bankSeekQuery.list().isEmpty();
    }

    @Override
    public List<BankSeek> findByKeyword(String keyword) {
        Session session = sessionFactory.getCurrentSession();
        Query<BankSeek> bankSeekQuery = session.createQuery("FROM BankSeek bs WHERE bs.rgn LIKE  '%' || :keyword || '%'" +
                                                                    "OR bs.newnum LIKE '%' || :keyword || '%' " +
                                                                    "OR bs.pzn LIKE '%' || :keyword || '%'");
        bankSeekQuery.setParameter("keyword", keyword);
        return bankSeekQuery.getResultList();
    }

    @Override
    public List<BankSeek> getBankSeek() {
        Session session = sessionFactory.getCurrentSession();
        Query<BankSeek> bankSeekQuery = session.createQuery("FROM BankSeek", BankSeek.class).setMaxResults(20);
        return bankSeekQuery.getResultList();
    }

    @Override
    public void saveBankSeek(BankSeek bankSeek) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(bankSeek);
    }

    @Override
    public void deleteBankSeek(String vkey) {
        Session session = sessionFactory.getCurrentSession();
        Query <BankSeek> query = session.createQuery("DELETE FROM BankSeek WHERE vkey=:vkey");
        query.setParameter("vkey", vkey);
        query.executeUpdate();
    }

    @Override
    public BankSeek getBank(String vkey) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(BankSeek.class, vkey);
    }
}
