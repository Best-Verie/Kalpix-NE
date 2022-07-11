/**
 * @author: ntwari egide
 * @description: User end points controller
 */

package com.kaplix.downloader.server.controllers;

import com.kaplix.downloader.server.config.JwtTokenUtil;
import com.kaplix.downloader.server.dtos.UserDto;
import com.kaplix.downloader.server.exceptions.UserNotFoundException;
import com.kaplix.downloader.server.models.User;
import com.kaplix.downloader.server.repositories.UserRepository;
import com.kaplix.downloader.server.serviceImpl.UserServiceImpl;
import com.kaplix.downloader.server.services.JwtUserDetailsService;
import com.kaplix.downloader.server.utils.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }



    @GetMapping("/{id}")
    public User findUser(@PathVariable UUID id){
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){

        User deleted =  userService.deleteUser(id);

        return ResponseEntity.ok(deleted);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody UserDto updateUser) throws RoleNotFoundException {

        User saveUser = userService.updateUser(updateUser,id);

        if(! bCryptPasswordEncoder.matches(updateUser.getPassword(), saveUser.getPassword())) {

            throw new UserNotFoundException("You entered incorrect old password");
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(saveUser.getUsername(), updateUser.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtil.generateJwtToken(authentication);

        return ResponseEntity.ok(new JwtResponse(jwt,
                saveUser.getId(),
                saveUser.getUsername(),
                saveUser.getEmail(),
                null));
    }


}
