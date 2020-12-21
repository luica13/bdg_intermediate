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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;


    //@ElementCollection(targetClass = Roles.class)
    @ManyToMany
    private Set<Roles> role;
    @OneToMany(mappedBy = "id")
    private Set<BancAcount> bancAcounts;
    private String pass;

    @Embeddable
    private class Contact{
        private String address;
        private String telNumber;
        private String email;

    }

}
