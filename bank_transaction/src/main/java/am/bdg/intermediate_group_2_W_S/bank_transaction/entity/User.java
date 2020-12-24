package am.bdg.intermediate_group_2_W_S.bank_transaction.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Embedded
    private Contact contact;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private Set<BankAccount> bankAccounts;

    private String pass;

    @Builder
    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Contact {
        private String address;
        private String telNumber;
        private String email;
    }
}
