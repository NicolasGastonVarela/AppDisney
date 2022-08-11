package com.AppDisney.AppDisney.Controller;

import com.AppDisney.AppDisney.DTO.LoginDTO;
import com.AppDisney.AppDisney.DTO.RegisterDTO;
import com.AppDisney.AppDisney.Model.Role;
import com.AppDisney.AppDisney.Model.User;
import com.AppDisney.AppDisney.Repository.RoleRepository;
import com.AppDisney.AppDisney.Repository.UserRepository;
import com.AppDisney.AppDisney.Security.JWTAuthResponseDTO;
import com.AppDisney.AppDisney.Security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<JWTAuthResponseDTO> authenticateUser(@RequestBody LoginDTO loginDTO){
        Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(), loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        //obtenemos el token de jwtTokenProvider
        String token = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JWTAuthResponseDTO(token));

        //return new ResponseEntity<>("Ha iniciado sesion con exito", HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> userRegister(@RequestBody RegisterDTO registerDTO){
        if (userRepository.existsByUsername(registerDTO.getUsername())){
            return new ResponseEntity<>("Nombre de usuario ya existe", HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByEmail(registerDTO.getEmail())){
            return new ResponseEntity<>("Email ya existe", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setName(registerDTO.getName());
        user.setUsername(registerDTO.getUsername());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        Role role = roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoleSet(Collections.singleton(role));

        userRepository.save(user);

        return new ResponseEntity<>("Usuario registrado exitosamente", HttpStatus.OK);
    }
}
