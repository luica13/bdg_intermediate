package am.bdg.intermediate_group_2_W_S.bank_transaction.service;

import am.bdg.intermediate_group_2_W_S.bank_transaction.dto.UserDto;

public interface BankAccountService {
    UserDto create(Long userId);
}
