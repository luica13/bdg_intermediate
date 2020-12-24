package am.bdg.intermediate_group_2_W_S.bank_transaction.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne
    @Column(nullable = false)
    private User user;

    @OneToMany(mappedBy = "bankAccount")
    private Set<Transaction> transactions;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    public BankAccount(User user, String accountNumber) {
        this.user = user;
        this.accountNumber = accountNumber;
    }
}
