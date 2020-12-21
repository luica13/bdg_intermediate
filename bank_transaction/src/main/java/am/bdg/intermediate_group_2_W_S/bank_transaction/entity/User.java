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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;



    @ManyToMany
    private Set<Role> role;
    @OneToMany(mappedBy = "user")
    private Set<BankAcount> bankAcounts;
    private String pass;
    @Embedded
    private Contact contact;

    @Embeddable
    private class Contact{
        private String address;
        private String telNumber;
        private String email;

    }

}
