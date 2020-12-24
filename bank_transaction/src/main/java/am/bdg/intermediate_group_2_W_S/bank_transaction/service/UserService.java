package am.bdg.intermediate_group_2_W_S.bank_transaction.service;

import am.bdg.intermediate_group_2_W_S.bank_transaction.dto.UserDto;
import am.bdg.intermediate_group_2_W_S.bank_transaction.entity.Role;

public interface UserService extends BaseService<UserDto> {

    UserDto register(UserDto userDto);

    UserDto editRole(Role role);

    UserDto changeRole(Long id, String role);
}
