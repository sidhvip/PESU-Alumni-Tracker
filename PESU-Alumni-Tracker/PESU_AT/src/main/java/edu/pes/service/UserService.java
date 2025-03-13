package edu.pes.service;

import edu.pes.dto.UserDto;
import edu.pes.entity.Role;
import edu.pes.entity.User;
import edu.pes.repository.RoleRepository;
import edu.pes.repository.UserRepository;
import edu.pes.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceInterface {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AlumniService alumniService;

    public UserService(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           AlumniService alumniService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.alumniService = alumniService;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());

        //encrypt the password once we integrate spring security
        //user.setPassword(userDto.getPassword());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleRepository.findByName("ROLE_USER");
        if(role == null){
            role = checkRoleExist();
        }

        user.setSrn(userDto.getSrn());
        user.setLinkedinurl(userDto.getLinkedinurl());
        user.setPhonenum(userDto.getPhonenum());

        user.setRoles(Arrays.asList(role));

        user.setAlumni(alumniService.findBySrn(user.getSrn()));

        userRepository.save(user);

        alumniService.updateUser(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findBySrn(String srn) {
        return userRepository.findBySrn(srn);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> convertEntityToDto(user))
                .collect(Collectors.toList());
    }

    private UserDto convertEntityToDto(User user){
        UserDto userDto = new UserDto();
        String[] name = user.getName().split(" ");
        userDto.setFirstName(name[0]);
        userDto.setLastName(name[1]);
        userDto.setEmail(user.getEmail());
        userDto.setSrn(user.getSrn());
        userDto.setLinkedinurl(user.getLinkedinurl());
        userDto.setPhonenum(user.getPhonenum());
        return userDto;
    }

    private Role checkRoleExist() {
        Role role = new Role();
 
        role.setName("ROLE_USER");
        return roleRepository.save(role);
    }
}
