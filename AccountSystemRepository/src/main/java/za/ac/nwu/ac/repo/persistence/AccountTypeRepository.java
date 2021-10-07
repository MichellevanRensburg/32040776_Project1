package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

    @Query(value = "SELECT" +
            "ACCOUNT_TYPE_ID," +
            "ACCOUNT_TYPE_NAME," +
            "CREATION_DATE," +
            "MNEMONIC," +
            "FROM " +
            "ACCOUNT_TYPE" +
            "WHERE MNEMONIC = :mnemonic ", nativeQuery = true)
    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);
    //pull out
    @Query(value = "SELECT" +
            "         at" +
            "     FROM " +
            "         AccountType at" +
            "     WHERE at.mnemonic = :mnemonic ", nativeQuery = true)
    AccountType getAccountTypeByMnemonic(String mnemonic);
    //constructor to pull out form different tables
    @Query(value = "SELECT new za.ac.nwu.domain.dto.AccountTypeDto(" +
            "         at.mnemonic," +
            "         at.accountTypeName," +
            "         at.creationDate," +
            "     FROM " +
            "         AccountType at" +
            "     WHERE at.mnemonic = :mnemonic ", nativeQuery = true)
    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);

    AccountType getAccountTypeDbEntityByMnemonic(String accountTypeMnemonic);
}
