package am.bdg.intermediate_group_2_W_S.bank_transaction.service;

import am.bdg.intermediate_group_2_W_S.bank_transaction.dto.TransactionDto;
import am.bdg.intermediate_group_2_W_S.bank_transaction.enums.TransactionStatus;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService extends BaseService<TransactionDto>{
    boolean accept(Long id);

    TransactionDto create(TransactionDto transactionDto);

    List<TransactionDto> getAllTransactions(Long userId);

    List<TransactionDto> getTransactionByCreatedDay(Long userId, LocalDate date);

    boolean cancel(Long id);

    boolean delete(Long id);

    TransactionDto getTransactionByCreatedDayAndStatus(Long userId, LocalDate date, String status);
}
