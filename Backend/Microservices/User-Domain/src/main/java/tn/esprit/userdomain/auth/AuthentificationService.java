package tn.esprit.userdomain.auth;

import jakarta.mail.MessagingException;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.userdomain.email.EmailService;
import tn.esprit.userdomain.email.EmailTemplate;
import tn.esprit.userdomain.roles.RoleRepository;
import tn.esprit.userdomain.user.Token;
import tn.esprit.userdomain.user.TokenRepository;
import tn.esprit.userdomain.user.User;
import tn.esprit.userdomain.user.UserRepository;


import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class AuthentificationService {
    @Autowired
    private final RoleRepository roleRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final TokenRepository tokenRepository;
    @Autowired
    private final EmailService emailService;

    @Value("${application.mailing.frontend.activation-url}")
    private String activationUrl;

    public AuthentificationService(RoleRepository roleRepository, PasswordEncoder passwordEncoder, UserRepository userRepository, TokenRepository tokenRepository, EmailService emailService) {
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.emailService = emailService;
    }

    public void registerUser(RegistrationRequest request) throws MessagingException {
        // Get the "ROLE_USER" role from the database
        var userRole = roleRepository.findByRoleName("ROLE_USER")
                .orElseThrow(() -> new IllegalStateException("Role not found"));

        // Create a new user
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .accountLocked(false)
                .enabled(false)
                .roles(List.of(userRole))
                .build();

        // Save the user in the database
        userRepository.save(user);

        // Send validation email
        sendValidationEmail(user);
    }


    private void sendValidationEmail(User user)  throws MessagingException {
        var newToken = generateAndSaveActivationToken(user);

        //send Email
        emailService.sendEmail(
                user.getEmail() ,
                user.getFullName(),
                EmailTemplate.ACTIVATION_ACCOUNT.name(),
                activationUrl,
                newToken,
                "Account Activation"
        );

    }

    private String generateAndSaveActivationToken(User user) {
        // generate a token
        String generatedToken = generateActivationCode(6);
        var token = Token.builder()
                .token(generatedToken)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(15))
                .user(user)
                .build();
        tokenRepository.save(token);
        return  generatedToken ;
    }

    private String generateActivationCode(int length) {
        String character = "0123456789";
        StringBuilder activationCode = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(character.length());
            activationCode.append(character.charAt(randomIndex));

        }
        return activationCode.toString();
    }

}
