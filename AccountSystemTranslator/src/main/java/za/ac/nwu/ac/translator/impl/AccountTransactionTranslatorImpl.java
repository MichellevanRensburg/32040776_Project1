package za.ac.nwu.ac.translator.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {
    private final AccountTransactionRepository accountTransactionRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountTransactionTranslatorImpl.class);

    @Autowired
    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository){
        this.accountTransactionRepository = accountTransactionRepository;
    }

    @Override
    public AccountTransaction save(AccountTransaction accountTransaction){
        try {
            return accountTransactionRepository.save(accountTransaction);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public List<AccountTransaction> getAllAccountTransactions(){
        List<AccountTransaction> accountTransactions;
        try{
            accountTransactions = new ArrayList<>(accountTransactionRepository.findAll());
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
        return accountTransactions;
    }

    @Override
    public AccountTransaction getAccountTransactionByPk(Long transactionId){
        try{
            return accountTransactionRepository.findById(transactionId).orElse(null);
        }catch (Exception e){
            throw  new RuntimeException("Unable to read from the DB", e);
        }
    }

}
