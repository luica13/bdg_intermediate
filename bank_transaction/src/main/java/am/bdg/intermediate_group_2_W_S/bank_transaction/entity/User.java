package am.bdg.intermediate_group_2_W_S.bank_transaction.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Embedded
    private Contact contact;

    @ManyToMany
    private Set<Roles> role;

    @OneToMany(mappedBy = "user")
    private Set<BankAccount> bankAccounts;

    private String pass;

    @Embeddable
    @Data
    private class Contact {
        private String address;
        private String telNumber;
        private String email;
    }
}
