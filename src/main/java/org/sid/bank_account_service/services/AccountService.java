package org.sid.bank_account_service.services;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bank_account_service.dto.BankAccountRequestDTO;
import org.sid.bank_account_service.dto.BankAccountResponseDTO;
import org.sid.bank_account_service.entities.BankAccount;
import org.springframework.stereotype.Service;
@SuppressWarnings("unused")

public interface AccountService {

    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
    public BankAccountResponseDTO updateAccount(String id,BankAccountRequestDTO bankAccount);

}
