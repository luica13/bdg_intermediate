package am.bdg.intermediate_group_2_W_S.bank_transaction.dto;

import am.bdg.intermediate_group_2_W_S.bank_transaction.enums.RoleTypes;
import lombok.Data;

@Data
public class RoleDto {

    private Long id;

    private RoleTypes type;
}
