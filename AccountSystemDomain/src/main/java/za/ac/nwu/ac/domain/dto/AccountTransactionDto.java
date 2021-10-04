package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.ac.nwu.ac.domain.persistense.AccountTransaction;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class AccountTransactionDto implements Serializable {

    private static final long serialVersionUID = -6731456901152363824L;
    private Long transactionId;
    private String accountTypeMnemonic;
    private Long memberId;
    private Long amount;
    private LocalDate transactionDate;

    public AccountTransactionDto() {
    }

    public AccountTransactionDto(Long transactionId, String accountTypeMnemonic, Long memberId, Long amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction) {
        this.transactionId = accountTransaction.getTransactionId();
        this.accountTypeMnemonic = accountTransaction.getAccountType().getMnemonic();
        this.memberId = accountTransaction.getMemberId();
        this.amount = accountTransaction.getAmount();
        this.transactionDate = accountTransaction.getTransactionDate();
    }

    @JsonIgnore
    public AccountTransaction buildAccountTransaction(AccountTransactionDto accountType){
        return new AccountTransaction(this.getTransactionId(), accountType, this.getMemberId(), this.getAmount(), this.getTransactionDate());
    }

    public Long getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountTypeMnemonic() {return accountTypeMnemonic;}
    public void setAccountTypeMnemonic(String accountTypeMnemonic) {
        this.accountTypeMnemonic = accountTypeMnemonic;
    }

    public Long getMemberId() {
        return memberId;
    }
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getAmount() {
        return amount;
    }
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountTypeMnemonic, that.accountTypeMnemonic)
                && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @JsonIgnore
    public AccountTransaction getAccountTransaction(){
        return new AccountTransaction(getTransactionId(), getAccountTypeMnemonic(), getMemberId(),getAmount(),getTransactionDate());
    }

    @Override
    public int hashCode(){return Objects.hash(transactionId,accountTypeMnemonic,memberId,amount,transactionDate);}

    @Override
    public String toString(){
        return "AccountTransactionDto{" +
                ", transactionId='" + transactionId + '\'' +
                ", accountTypeMnemonic='" + accountTypeMnemonic + '\'' +
                ", memberId=" + memberId +
                ", amount='" + amount + '\'' +
                ", transactionDate=" + transactionDate +
                '}';
    }

}
