package application.dao;

import application.entity.BankSeek;

import java.util.List;

public interface BankSeekDAO {

    boolean validateBank (String keyword);

    List<BankSeek> findByKeyword(String keyword);

    List<BankSeek> getBankSeek();

    void saveBankSeek(BankSeek bankSeek);

    void deleteBankSeek(String vkey);

    BankSeek getBank(String vkey);

}
