package application.service;

import application.dao.PznDAO;
import application.entity.Pzn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PznServiceImpl implements PznService {

    @Autowired
    private PznDAO pznDAO;

    @Override
    @Transactional
    public List<Pzn> getPznList() {
        return pznDAO.getPznList();
    }
}
