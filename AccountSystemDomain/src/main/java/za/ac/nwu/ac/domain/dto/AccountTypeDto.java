package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgonore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistense.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountType", description = "A DTO that represents the Account Type")

public class AccountTypeDto implements Serializable{

    private static final long serialVersionID = 5346853206480289868L;

    private String mnemonic;
    private String accountTypeName;
    private LocalDate creationDate;

    public AccountTypeDto(){
    }

    public AccountType(String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }

    public AccountTypeDto(AccountType accountType){
        this.setAccountTypeName(accountType.getAccountTypeName());
        this.setCreationDate(accountType.getCreationDate());
        this.setMnemonic(accountType.getMnemonic())
    }

    @ApiModelProperty(postion = 1,
            value = "Account Mnemonic",
            name = "Mnemonic",
            notes = "Uniquely identifies the account type",
            datatype = "java.lang.String",
            example = "MILES",
            required = true)
    public String getMnemonic() {return mnemonic;}

    public void setMnemonic(String mnemonic) {this.mnemonic = mnemonic;}

    @ApiModelProperty(postion = 2,
            value = "Account Name",
            name = "Name",
            notes = "The name of the Account type",
            datatype = "java.lang.String",
            example = "Miles",
            allowEmptyValue = false,
            required = true)
    public String getAccountTypeName() {return accountTypeName;}

    public void setAccountTypeName(String accountTypeName) {this.accountTypeName = accountTypeName;}

    @ApiModelProperty(postion = 3,
            value = "Account Creation Date",
            name = "CreationDate",
            notes = "This is the date on which the Account was created",
            datatype = "java.lang.String",
            example = "2020-01",
            allowEmptyValue = false,
            required = false)

    public LocalDate getCreationDate() {return creationDate;}

    public void setCreationDate(LocalDate creationDate) {this.creationDate = creationDate;}
}
