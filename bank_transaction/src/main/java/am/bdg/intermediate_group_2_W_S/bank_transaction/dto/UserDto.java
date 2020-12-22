package am.bdg.intermediate_group_2_W_S.bank_transaction.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Set;

@Data
public class UserDto {

    private long id;

    private String name;

    private ContactDto contactDto;

    private Set<RoleDto> role;

    private Set<BankAccountDto> bankAccountDtos;

    @JsonIgnore
    private String pass;

    @Data
    private class ContactDto {
        private String address;
        private String telNumber;
        private String email;
    }
}
