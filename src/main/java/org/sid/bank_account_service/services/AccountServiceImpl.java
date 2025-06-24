package org.sid.bank_account_service.services;

import org.sid.bank_account_service.dto.BankAccountRequestDTO;
import org.sid.bank_account_service.dto.BankAccountResponseDTO;
import org.sid.bank_account_service.entities.BankAccount;
import org.sid.bank_account_service.mappers.AccountMapper;
import org.sid.bank_account_service.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@SuppressWarnings("unused")

@Service
@Transactional  // Toutes les méthodes métier sont transactionelles
public class AccountServiceImpl implements AccountService {

    private BankAccountRepository bankAccountRepository;
    private AccountMapper accountMapper;

    public AccountServiceImpl(BankAccountRepository bankAccountRepository, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .type(bankAccountDTO.getType())
                .id(UUID.randomUUID().toString())
                .currency(bankAccountDTO.getCurrency())
                .createAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        return accountMapper.fromBankAccount(savedBankAccount);
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id,BankAccountRequestDTO bankAccount) {
        BankAccount newBankAccount = BankAccount.builder()
                .type(bankAccount.getType())
                .id(id)
                .currency(bankAccount.getCurrency())
                .createAt(new Date())
                .balance(bankAccount.getBalance())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(newBankAccount);
        BankAccountResponseDTO mappedSavedBankAccount = accountMapper.fromBankAccount(savedBankAccount);
        return mappedSavedBankAccount;
    }
}
