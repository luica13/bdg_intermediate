package am.bdg.intermediate_group_2_W_S.bank_transaction.service.impl;

import am.bdg.intermediate_group_2_W_S.bank_transaction.dto.TransactionDto;
import am.bdg.intermediate_group_2_W_S.bank_transaction.entity.Transaction;
import am.bdg.intermediate_group_2_W_S.bank_transaction.enums.TransactionStatus;
import am.bdg.intermediate_group_2_W_S.bank_transaction.repository.TransactionRepository;
import am.bdg.intermediate_group_2_W_S.bank_transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public boolean accept(Long id) {
        return false;
    }

    @Override
    public TransactionDto create(TransactionDto transactionDto) {
        transactionDto.setStatus(TransactionStatus.PENDING);
        Transaction transaction = Common.buildTransactionFromTransactionDto(transactionDto);
        transaction = transactionRepository.save(transaction);
        return Common.buildTransactionDtoFromTransaction(transaction);
    }

    @Override
    public List<TransactionDto> getAllTransactions(Long userId) {
        return transactionRepository.findAllByUserId(userId).stream().map(Common::buildTransactionDtoFromTransaction).collect(Collectors.toList());
    }

    @Override
    public TransactionDto get(Long id) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);

        if (!optionalTransaction.isPresent()) {
            throw new EntityNotFoundException(String.format("Transaction by id: %s not found.", id));
        }
        Transaction transaction = optionalTransaction.get();
        return Common.buildTransactionDtoFromTransaction(transaction);
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
