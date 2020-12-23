package am.bdg.intermediate_group_2_W_S.bank_transaction.dto;

import am.bdg.intermediate_group_2_W_S.bank_transaction.enums.RoleType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleDto {

    private Long id;

    private RoleType type;
}
