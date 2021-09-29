package za.ac.nuw.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.util.List;

public class AccountTypeTranslator {
    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto create(AccountTypeDto accountType);
}
