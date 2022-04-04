package com.pjatk.bank;

public class BankAccount {
    private String accountNumber;
    private double currentMoney;

    public BankAccount(String number){
        this.accountNumber = number;
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }

    public double getCurrentMoney(){
        return this.currentMoney;
    }
    public void addMoney(double value){
        this.currentMoney += value;
    }
    public void subtractMoney(double value){
            this.currentMoney -= value;
    }
}
