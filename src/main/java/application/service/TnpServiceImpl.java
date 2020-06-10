package application.service;

import application.dao.TnpDAO;
import application.entity.Tnp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TnpServiceImpl implements TnpService {

    @Autowired
    private TnpDAO tnpDAO;

    @Override
    @Transactional
    public List<Tnp> getTnpList() {
        return tnpDAO.getTnpList();
    }
}
