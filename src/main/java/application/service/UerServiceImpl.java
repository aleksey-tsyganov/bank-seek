package application.service;


import application.dao.UerDAO;
import application.entity.Uer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UerServiceImpl implements UerService {

    @Autowired
    private UerDAO uerDAO;

    @Override
    @Transactional
    public List<Uer> getUerList() {
        return uerDAO.getUerList();
    }
}
