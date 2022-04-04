package com.pjatk.bank;

import java.util.ArrayList;
import java.util.HashMap;

public class BankAccountManager {
    private HashMap<String, BankAccount> accounts = new HashMap<>();
    private HashMap<BankOperationType, ArrayList<BankAccountOperation>> operations = new HashMap<>();

    public BankAccountManager() {

    }

    public void addAccount(BankAccount account) {
        this.accounts.put("XD?", account);
    }

    public void registerOperation(BankAccountOperation operation) {
        this.operations.computeIfAbsent(operation.getType(), k -> new ArrayList<BankAccountOperation>());
        this.operations.get(operation.getType()).add(operation);
//        this.operations.put(operation.getType(), new ArrayList<>());
    }

    public void performDeposits() {
        ArrayList<BankAccountOperation> depositList = operations.get(BankOperationType.DEPOSIT);
        for (BankAccountOperation deposit : depositList) {
            BankAccount accountTarget = deposit.getSourceBankAccount();
            accountTarget.addMoney(deposit.getMoney());
        }
    }

    public void performWithdrawals() {
        ArrayList<BankAccountOperation> withdrawalsList = operations.get(BankOperationType.WITHDRAWAL);
        for (BankAccountOperation withdraw : withdrawalsList){
            BankAccount accountTarget = withdraw.getSourceBankAccount();
            if (accountTarget.getCurrentMoney()>=withdraw.getMoney()){
                accountTarget.subtractMoney(withdraw.getMoney());
            }else{
                System.out.println("Niewystarczająca ilość środków na koncie :C");
            }
        }
    }
    public void performTransfers(){
        ArrayList<BankAccountOperation> transferList = operations.get(BankOperationType.TRANSFER);
        for (BankAccountOperation transfer : transferList){
            BankAccount accountSource = transfer.getSourceBankAccount();
            BankAccount accountTarget = transfer.getTargetBankAccount();
            if (accountSource.getCurrentMoney()>=transfer.getMoney()){
                accountSource.subtractMoney(transfer.getMoney());
                accountTarget.addMoney(transfer.getMoney());
            }else{
                System.out.println("Niewystarczająca ilość środków na koncie :C");
            }
        }
    }
}
