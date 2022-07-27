package me.dio.academia.digital.config.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.config.dto.Login;
import me.dio.academia.digital.config.dto.Sessao;
import me.dio.academia.digital.config.jwt.JWTCreator;
import me.dio.academia.digital.config.jwt.JWTObject;
import me.dio.academia.digital.config.jwt.SecurityConfig;
import me.dio.academia.digital.config.userConfig.User;
import me.dio.academia.digital.config.userConfig.UserRepository;

@RestController
public class LoginController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private UserRepository repository;

    @SuppressWarnings("unused")
	@PostMapping("/login")
    public Sessao logar(@RequestBody Login login){
    	System.out.println(login.getUsername());
        User user = repository.findByUsername(login.getUsername());
        System.out.println(user.getUsername());
        if(user!=null) {
            boolean passwordOk =  encoder.matches(login.getPassword(), user.getPassword());
            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o login: " + login.getUsername());
            }
            //Estamos enviando um objeto Sessão para retornar mais informações do usuário
            Sessao sessao = new Sessao();
            sessao.setLogin(user.getUsername());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
            jwtObject.setRoles(user.getRoles());
            sessao.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
            return sessao;
        }else {
            throw new RuntimeException("Erro ao tentar fazer login");
        }
    }
}
