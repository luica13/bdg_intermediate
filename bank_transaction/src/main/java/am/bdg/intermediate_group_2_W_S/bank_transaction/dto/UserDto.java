package am.bdg.intermediate_group_2_W_S.bank_transaction.dto;

import lombok.AllArgsConstructor;
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

    private Set<RoleDto> roles;

    private String pass;

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ContactDto {
        private String address;
        private String telNumber;
        private String email;

//        public ContactDto(User.Contact contact) {
//            this.address = contact.getAddress();
//            this.telNumber = contact.getTelNumber();
//            this.email = contact.getEmail();
//        }
    }
}
