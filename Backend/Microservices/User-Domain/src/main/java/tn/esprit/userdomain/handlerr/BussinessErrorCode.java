package tn.esprit.userdomain.handlerr;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

public enum BussinessErrorCode {
    NO_CODE(0 , NOT_IMPLEMENTED , "No code"),
    INCORRECT_CURRENT_PASSWORD(300 , BAD_REQUEST , "Incorrect password"),
    NEW_PASSWORD_DOES_NOT_MATCH(301 , BAD_REQUEST , "New  password does not match "),
    ACCOUNT_LOCKED(302 , FORBIDDEN , "User account is Locked"),
    ACCOUNT_DISABLED(303 , FORBIDDEN , "User account is Disabled"),
    BAD_CREDENTIAL(304 , FORBIDDEN , "lOGIN / Password is incorrect")
    ;
    @Getter
        private final  int code ;
    @Getter
    private final String description;
    @Getter
    private final HttpStatus httpStatus ;

    BussinessErrorCode(int code,  HttpStatus httpStatus , String description) {
        this.code = code;
        this.description = description;
        this.httpStatus = httpStatus;
    }
}
