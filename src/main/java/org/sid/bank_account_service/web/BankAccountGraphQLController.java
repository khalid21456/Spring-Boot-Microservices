package org.sid.bank_account_service.web;


import org.sid.bank_account_service.entities.BankAccount;
import org.sid.bank_account_service.repositories.BankAccountRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;
import org.w3c.dom.stylesheets.LinkStyle;

@SuppressWarnings("unused")

@Controller
public class BankAccountGraphQLController {

    private BankAccountRepository bankAccountRepository;

    public BankAccountGraphQLController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @QueryMapping
    public List<BankAccount> accountList() {
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public BankAccount bankAccountById(@Argument String id) {
        return bankAccountRepository.findById(id).orElseThrow(()->
                new RuntimeException(String.format("Account %s not found",id)));
    }
}
