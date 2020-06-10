package application.service;

import application.dao.RegDAO;
import application.entity.Reg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegServiceImpl implements RegService {

    @Autowired
    private RegDAO regDAO;

    @Override
    @Transactional
    public List<Reg> getRegList() {
        return regDAO.getRegList();
    }
}
