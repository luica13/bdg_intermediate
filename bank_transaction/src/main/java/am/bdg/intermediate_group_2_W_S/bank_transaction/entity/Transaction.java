package am.bdg.intermediate_group_2_W_S.bank_transaction.entity;

import am.bdg.intermediate_group_2_W_S.bank_transaction.e.TransactionStatus;
import am.bdg.intermediate_group_2_W_S.bank_transaction.e.TransactionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private BankAccount bankAccount;

    private LocalDate createdDate;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    private BigDecimal amount;//if(type=DEPOSIT)amount>0 else amount<0

}
