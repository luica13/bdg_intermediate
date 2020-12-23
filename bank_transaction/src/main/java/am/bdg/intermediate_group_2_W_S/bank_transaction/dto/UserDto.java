package am.bdg.intermediate_group_2_W_S.bank_transaction.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
public class UserDto {

    private long id;

    private String name;

    private ContactDto contactDto;

    private Set<RoleDto> role;

    private Set<BankAccountDto> bankAccountDtos;

    private String pass;

    @Data
    @NoArgsConstructor
    public static class ContactDto {
        private String address;
        private String telNumber;
        private String email;
    }
}
