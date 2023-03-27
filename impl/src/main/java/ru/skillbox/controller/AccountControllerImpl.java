package ru.skillbox.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skillbox.model.AccountController;
import ru.skillbox.request.account.AccountEditRq;
import ru.skillbox.response.ErrorResponse;
import ru.skillbox.response.Responsable;
import ru.skillbox.service.UserService;
import ru.stachek66.nlp.mystem.holding.Factory;
import ru.stachek66.nlp.mystem.holding.MyStem;
import ru.stachek66.nlp.mystem.holding.MyStemApplicationException;
import ru.stachek66.nlp.mystem.holding.Request;
import ru.stachek66.nlp.mystem.model.Info;
import scala.Option;
import scala.collection.JavaConversions;

import java.io.File;

@RestController
@RequiredArgsConstructor
public class AccountControllerImpl implements AccountController {

  //  private final PersonService personService;

    private final UserService userService;

    private final static MyStem mystemAnalyzer =
            new Factory("-igd --eng-gr --format json --weight")
                    .newMyStem("3.0", Option.<File>empty()).get();

    @Override
    @GetMapping("/me")
    public ResponseEntity<Responsable> getCurrentPerson() {
        try {
            Iterable<Info> result =
                    null;
            try {
                result = JavaConversions.asJavaIterable(
                        mystemAnalyzer
                                .analyze(Request.apply("И вырвал грешный мой язык"))
                                .info()
                                .toIterable());
            } catch (MyStemApplicationException e) {
                throw new RuntimeException(e);
            }

            for (final Info info : result) {
                System.out.println(info.initial() + " -> " + info.lex().get()
                );
            }
            return null;//ResponseEntity.ok(AccountMapper.INSTANCE.personToAccountDto(personService.getCurrentPerson()));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse().getResponse(e.getMessage()));
        }
    }

    @Override
    @PutMapping("/me")
    public ResponseEntity<Responsable> editingAccount(@RequestBody AccountEditRq accountEditRq) {
        try {
            return null;//ResponseEntity.ok(personService.editing(accountEditRq));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse().getResponse(e.getMessage()));
        }
    }

    @Override
    @DeleteMapping("/me")
    public ResponseEntity<Responsable> deleteAccount() {
        try {
            userService.deleteCurrentUser();
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse().getResponse(e.getMessage()));
        }

    }

    @Override
    @PutMapping("/block/{id}")
    public ResponseEntity<Responsable> accountBlockingById(@PathVariable long id) {
        try {
            userService.isBlockUserById(id, true);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse().getResponse(e.getMessage()));
        }
    }

    @Override
    @DeleteMapping("/block/{id}")
    public ResponseEntity<Responsable> accountUnblockingById(@PathVariable long id) {
        try {
            userService.isBlockUserById(id, false);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse().getResponse(e.getMessage()));
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Responsable> getUserById(@PathVariable long id) {
        try {
            return null;// ResponseEntity.ok(AccountMapper.INSTANCE.personToAccountDto(personService.getPersonById(id)));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse().getResponse(e.getMessage()));
        }
    }
}
