package am.bdg.intermediate_group_2_W_S.bank_transaction.dto;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class BankAccountDto {
    private long id;

    private UserDto userDto;

    //private Set<TransactionDto> transactionDtos;

    private String accountNumber;

}
