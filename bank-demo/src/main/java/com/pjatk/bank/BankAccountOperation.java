package com.pjatk.bank;

import java.time.LocalDateTime;

public class BankAccountOperation {
    private
    BankAccount sourceBankAccount;
    BankAccount targetBankAccount;
    double money;
    BankOperationType type;
    LocalDateTime date;

    public BankAccountOperation(BankOperationType type){
        this.type = type;
    }

    public void setSourceBankAccount(BankAccount sourceBankAccount) {
        this.sourceBankAccount = sourceBankAccount;
    }
    public void setTargetBankAccount(BankAccount targetBankAccount){
        this.targetBankAccount = targetBankAccount;
    }

    public BankAccount getSourceBankAccount() {
        return this.sourceBankAccount;
    }
    public BankAccount getTargetBankAccount(){
        return this.targetBankAccount;
    }

    public BankOperationType getType(){
        return type;
    }
    public void setDate(LocalDateTime time){
        this.date = time;
    }
    public LocalDateTime getDate(){
        return this.date;
    }
    public void setMoney(double money) {
        this.money = money;
    }
    public double getMoney() {
        return this.money;
    }
}
