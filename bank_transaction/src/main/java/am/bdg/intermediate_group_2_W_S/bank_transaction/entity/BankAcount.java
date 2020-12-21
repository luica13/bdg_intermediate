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
public class BankAcount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne(targetEntity = User.class)
    private  User user;
    @OneToMany(mappedBy = "bankAcount")
    private Set<Transaction> transactions;
    private String accountNumber;

}
