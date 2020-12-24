package am.bdg.intermediate_group_2_W_S.bank_transaction.repository;

import am.bdg.intermediate_group_2_W_S.bank_transaction.entity.Transaction;
import am.bdg.intermediate_group_2_W_S.bank_transaction.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Long> {
    @Query("select T from Transaction T where T.bankAccount.user.id = :userId")
    List<Transaction> findAllByUserId(Long userId);
}
