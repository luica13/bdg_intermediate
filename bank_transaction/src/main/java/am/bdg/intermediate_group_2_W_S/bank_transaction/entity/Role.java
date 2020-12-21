package am.bdg.intermediate_group_2_W_S.bank_transaction.entity;

import am.bdg.intermediate_group_2_W_S.bank_transaction.e.RoleTypes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "rols")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleTypes type;


}