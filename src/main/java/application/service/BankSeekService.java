package application.service;

import application.entity.BankSeek;

import java.util.List;

public interface BankSeekService {

    boolean validateBank (String keyword);

    List<BankSeek> getBanksList();

    void saveBankSeek(BankSeek bankSeek);

    void deleteBankSeek(String vkey);

    BankSeek getBank(String vkey);

    List<BankSeek> findByKeyword(String keyword);

    List<BankSeek> findBankByPzn(String keyword);
}
