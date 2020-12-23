package am.bdg.intermediate_group_2_W_S.bank_transaction.service.impl;

import am.bdg.intermediate_group_2_W_S.bank_transaction.dto.TransactionDto;
import am.bdg.intermediate_group_2_W_S.bank_transaction.enums.TransactionStatus;
import am.bdg.intermediate_group_2_W_S.bank_transaction.service.TransactionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Override
    public boolean accept(Long id) {
        return false;
    }

    @Override
    public TransactionDto create(TransactionDto transactionDto) {
        transactionDto.setStatus(TransactionStatus.PENDING);
        return null;
    }

    @Override
    public List<TransactionDto> getAllTransactions(Long userId) {
        return null;
    }

    @Override
    public List<TransactionDto> getTransaction(Long id) {
        return null;
    }

    @Override
    public List<TransactionDto> getTransactionByCreatedDay(Long userId, LocalDate date) {
        return null;
    }

    @Override
    public boolean cancel(Long id) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public TransactionDto getTransactionByCreatedDayAndStatus(Long userId, LocalDate date, String status) {
        return null;
    }

}
