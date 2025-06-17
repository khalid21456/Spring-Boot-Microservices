package org.sid.bank_account_service.web;


import org.sid.bank_account_service.entities.BankAccount;
import org.sid.bank_account_service.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api")
public class AccountRestConroller {

    private BankAccountRepository bankAccountRepository;

    public AccountRestConroller(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccounts(@PathVariable String id) {
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException("Account "+id+" Not Found"));
    }

    @PostMapping("/bankAccount")
    public BankAccount save(@RequestBody BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount) {
        BankAccount account = bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account introuvable"));
        if(account.getBalance() != 0) account.setBalance(bankAccount.getBalance());
        account.setCreateAt(new Date());
        if(account.getType() != null) account.setType(bankAccount.getType());
        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/deleteBankAccounts")
    public void delete(@RequestParam String id) {
        bankAccountRepository.deleteById(id);
    }

}
