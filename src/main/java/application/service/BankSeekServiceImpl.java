package application.service;

import application.dao.BankSeekDAO;
import application.entity.BankSeek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class BankSeekServiceImpl implements BankSeekService{

    @Autowired
    private BankSeekDAO bankSeekDAO;

    @Transactional
    public boolean validateBank (String keyword){return bankSeekDAO.validateBank(keyword);}

    @Override
    @Transactional
    public List<BankSeek> findByKeyword(String keyword) {
        return bankSeekDAO.findByKeyword(keyword);
    }

    @Override
    @Transactional
    public List<BankSeek> findBankByPzn(String keyword) {
        return bankSeekDAO.findBankByPzn(keyword);
    }

    @Override
    @Transactional
    public List<BankSeek> getBanksList() {
        return bankSeekDAO.getBankSeek();
    }

    @Override
    @Transactional
    public void saveBankSeek(BankSeek bankSeek) {
        bankSeekDAO.saveBankSeek(bankSeek);
    }

    @Override
    @Transactional
    public void deleteBankSeek(String vkey) {
        bankSeekDAO.deleteBankSeek(vkey);
    }

    @Override
    @Transactional
    public BankSeek getBank(String vkey) {
        return bankSeekDAO.getBank(vkey);
    }


}
