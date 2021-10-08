package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

import java.time.LocalDate;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
    /*@Query(value = "SELECT" +
            "         TRANSC_ID," +
            "         ACCOUNT_TYPE_ID," +
            "         MEMBER_ID," +
            "         AMOUNT," +
            "         BALANCE," +
            "     FROM " +
            "         ACCOUNT_TYPE_TX" +
            "     WHERE MEMBER_ID = :memberId ")
    AccountTransaction subractAccountType();*/
    /*@Query(value = "SELECT" +
            "         TRANSC_ID," +
            "         ACCOUNT_TYPE_ID," +
            "         MEMBER_ID," +
            "         AMOUNT," +
            "         BALANCE," +
            "     FROM " +
            "         ACCOUNT_TYPE_TX" +
            "     WHERE TRANSC_ID = :transid ")
    AccountTransaction getAccountTransactionByPk(Long transactionId);*/
}
