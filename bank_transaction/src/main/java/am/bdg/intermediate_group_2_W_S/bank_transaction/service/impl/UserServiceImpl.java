package am.bdg.intermediate_group_2_W_S.bank_transaction.service.impl;

import am.bdg.intermediate_group_2_W_S.bank_transaction.dto.RoleDto;
import am.bdg.intermediate_group_2_W_S.bank_transaction.dto.UserDto;
import am.bdg.intermediate_group_2_W_S.bank_transaction.entity.Role;
import am.bdg.intermediate_group_2_W_S.bank_transaction.entity.User;
import am.bdg.intermediate_group_2_W_S.bank_transaction.enums.RoleType;
import am.bdg.intermediate_group_2_W_S.bank_transaction.repository.RoleRepository;
import am.bdg.intermediate_group_2_W_S.bank_transaction.repository.UserRepository;
import am.bdg.intermediate_group_2_W_S.bank_transaction.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repository, RoleRepository roleRepository, PasswordEncoder encoder) {
        this.repository = repository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    @Override
    public UserDto register(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setPass(encoder.encode(userDto.getPass()));
        Role role = new Role();
        role.setType(RoleType.ROLE_USER);
        role = roleRepository.save(role);
        user.setRoles(Stream.of(role).collect(Collectors.toSet()));
        UserDto.ContactDto contactDto = userDto.getContactDto();
        user.setContact(new User.Contact());
        user.getContact().setAddress(contactDto.getAddress());
        user.getContact().setEmail(contactDto.getEmail());
        user.getContact().setTelNumber(contactDto.getTelNumber());
        user = repository.save(user);
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .roles(user.getRoles().stream()
                        .map(role1 -> RoleDto.builder().type(role1.getType()).build())
                        .collect(Collectors.toSet()))
                .build();
    }

    @Override
    public UserDto get(Long id) {
        Optional<User> userOptional = repository.findById(id);
        if (!userOptional.isPresent()) {
            throw new EntityNotFoundException(String.format("User by id: %s not found.", id));
        }
        User user = userOptional.get();

        return UserDto.builder()
                .id(id)
                .name(user.getName()).build();
    }


    @Override
    public UserDto changeRole(Long id, RoleType roleType) {
        Optional<Role> optionalRole = roleRepository.findRoleByType(roleType);
        Role role = optionalRole.orElseGet(() -> roleRepository.save(Role.builder().type(roleType).build()));

        Optional<User> optionalUser = repository.findById(id);
        if(!optionalUser.isPresent()){
            throw new EntityNotFoundException(String.format("Transaction by id: %s not found.", id));
        }
        User user = optionalUser.get();
        user.getRoles().add(role);
        repository.save(user);
        return Common.buildUserDtoFromUser(user);
    }

}
