package am.bdg.intermediate_group_2_W_S.bank_transaction.dto;

import am.bdg.intermediate_group_2_W_S.bank_transaction.enums.TransactionStatus;
import am.bdg.intermediate_group_2_W_S.bank_transaction.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@Data
public class TransactionDto {

    private long id;

    private BankAccountDto bankAccountDto;

    private LocalDate createdDate;

    private TransactionType type;

    private TransactionStatus status;

    private BigDecimal amount;//if(type=DEPOSIT)amount>0 else amount<0

}
