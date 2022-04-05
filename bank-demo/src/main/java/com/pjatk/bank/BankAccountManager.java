package com.pjatk.bank;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class BankAccountManager {
    private HashMap<String, BankAccount> accounts = new HashMap<>();
    private HashMap<BankOperationType, ArrayList<BankAccountOperation>> operations = new HashMap<>();
    private LocalDateTime sessionTime;

    public BankAccountManager() {
        sessionTime = LocalDate.now().atTime(17, 0);
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
            if (deposit.getDate().isAfter(sessionTime)){
                System.out.println("Operacja zaplanowana na następną sesję rozliczeniową.");
                System.out.println(deposit.getDate()+ " > " + sessionTime);
                continue;
            }
            BankAccount accountTarget = deposit.getSourceBankAccount();
            accountTarget.addMoney(deposit.getMoney());
        }
    }

    public void performWithdrawals() {
        ArrayList<BankAccountOperation> withdrawalsList = operations.get(BankOperationType.WITHDRAWAL);
        for (BankAccountOperation withdraw : withdrawalsList){
            BankAccount accountTarget = withdraw.getSourceBankAccount();
            if (withdraw.getDate().isAfter(sessionTime)){
                System.out.println("Operacja zaplanowana na następną sesję rozliczeniową.");
                System.out.println(withdraw.getDate()+ " > " + sessionTime);
                continue;
            }
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
            if (transfer.getDate().isAfter(sessionTime)){
                System.out.println("Operacja zaplanowana na następną sesję rozliczeniową.");
                System.out.println(transfer.getDate()+ " > " + sessionTime);
                continue;
            }
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
