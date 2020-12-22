package am.bdg.intermediate_group_2_W_S.bank_transaction.controller;

import am.bdg.intermediate_group_2_W_S.bank_transaction.service.BankAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BankAccountController {

    private final BankAccountService service;

    public BankAccountController(BankAccountService service) {
        this.service = service;
    }

    @PostMapping("/account")
    public ResponseEntity<?> create(@RequestParam(value = "user_id") Long userId) {
        return ResponseEntity.ok(service.create(userId));
    }
}
