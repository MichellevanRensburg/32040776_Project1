package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import javax.transaction.Transactional;

@Transactional
@Component("createAccountTransactionFlowName")
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CreateAccountTransactionFlowImpl.class);

    private final AccountTransactionTranslator accountTransactionTranslator;
    private final FetchAccountTypeFlow fetchAccountTypeFlow;

    @Autowired
    public CreateAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator,
                                            FetchAccountTypeFlow fetchAccountTypeFlow){
        this.accountTransactionTranslator = accountTransactionTranslator;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;}

    @Override
    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto){
        LOGGER.info("The input object was {}", accountTransactionDto);

        accountTransactionDto.setTransactionId(null);

        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(accountTransactionDto.getAccountTypeMnemonic());
        LOGGER.info("Got AccountType for {}", accountTransactionDto.getAccountTypeMnemonic());
        AccountTransaction accountTransaction = accountTransactionDto.buildAccountTransaction(accountType);
        //No cascade
        AccountTransaction createdAccountTransaction = accountTransactionTranslator.save(accountTransaction);
        AccountTransactionDto results = new AccountTransactionDto(createdAccountTransaction);

        LOGGER.info("The return object is {}", results);
        return results;
    }
}
