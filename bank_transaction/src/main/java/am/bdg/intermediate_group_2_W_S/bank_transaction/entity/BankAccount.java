package am.bdg.intermediate_group_2_W_S.bank_transaction.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "bankAccount")
    private Set<Transaction> transactions;

    @Column(unique = true)
    private String accountNumber;

}
