package tn.esprit.userdomain.auth;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@Tag(name="Authentification")
public class AuthentificationController {
    @Autowired
    private final AuthentificationService authentificationService;

    public AuthentificationController(AuthentificationService authentificationService) {
        this.authentificationService = authentificationService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> register(@Valid @RequestBody RegistrationRequest request) throws MessagingException {
        authentificationService.registerUser(request);
        return ResponseEntity.accepted().build();
    }
}
