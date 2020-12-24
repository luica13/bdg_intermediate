package am.bdg.intermediate_group_2_W_S.bank_transaction.service.impl;

import am.bdg.intermediate_group_2_W_S.bank_transaction.dto.TransactionDto;
import am.bdg.intermediate_group_2_W_S.bank_transaction.entity.Transaction;
import am.bdg.intermediate_group_2_W_S.bank_transaction.enums.TransactionStatus;
import am.bdg.intermediate_group_2_W_S.bank_transaction.enums.TransactionType;
import am.bdg.intermediate_group_2_W_S.bank_transaction.repository.TransactionRepository;
import am.bdg.intermediate_group_2_W_S.bank_transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.security.Principal;
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
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id) ;
        if (!optionalTransaction.isPresent()){
            throw new EntityNotFoundException(String.format("Transaction by id: %s not found.", id));
        }
        Transaction transaction = optionalTransaction.get();
        TransactionStatus transactionStatus = transaction.getStatus();

        if(!transactionStatus.equals(TransactionStatus.PENDING)){
            throw new IllegalArgumentException(String.format("Transaction status is: %s, but must be PENDING", transactionStatus.name()));
        }
        boolean retStatus = true;
        transaction.setStatus(TransactionStatus.ACCEPTED);
        if (TransactionType.WITHDRAWAL.equals(transaction.getType())){
            long userId = transaction.getBankAccount().getUser().getId();
            BigDecimal sum = transactionRepository.calculateSumOfUserId(userId);
            if(sum != null) {
                if (sum.compareTo(transaction.getAmount()) < 0) {
                    transaction.setStatus(TransactionStatus.CANCELED);
                    retStatus = false;
                }
            }else {
                transaction.setStatus(TransactionStatus.CANCELED);
                retStatus = false;
            }
        }


        transactionRepository.save(transaction);
        return retStatus;
    }

    @Override
    public TransactionDto create(TransactionDto transactionDto) {
        transactionDto.setStatus(TransactionStatus.PENDING);
        if (TransactionType.WITHDRAWAL.equals(transactionDto.getType())){
            transactionDto.setAmount(transactionDto.getAmount().multiply(BigDecimal.valueOf(-1)));
        }
        Transaction transaction = transactionRepository.save(Common.buildTransactionFromTransactionDto(transactionDto));
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
        return transactionRepository.findAllByCreatedDateAndBankAccount_User_Id(date, userId)
                .stream().map(Common::buildTransactionDtoFromTransaction).collect(Collectors.toList());
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
    public List<TransactionDto> getTransactionByCreatedDayAndStatus(Long userId, LocalDate date, TransactionStatus status) {
        return transactionRepository.findAllByCreatedDateAndStatusAndBankAccount_User_Id(date, status, userId)
                .stream().map(Common::buildTransactionDtoFromTransaction).collect(Collectors.toList());
    }


}
