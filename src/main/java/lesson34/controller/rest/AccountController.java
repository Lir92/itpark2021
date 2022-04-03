package lesson34.controller.rest;

import lesson34.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    @GetMapping
    public List<AccountDto> accounts(){ // получаем список всех аккаунтов
        return List.of();
    }

    @GetMapping({"/{id}", "/by-id/{id}"})
    public AccountDto getById(@PathVariable Integer id, @RequestHeader("Accept-encoding") String encoding){ // получаем список конкретного аккаунта, идентифицированного по Id.
        return new AccountDto();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public AccountDto createAccount(@RequestBody AccountDto accountDto){ // создаём аккаунт
        if (new Random().nextBoolean()){
            throw new IllegalArgumentException();
        }
        return new AccountDto();
    }

    @PutMapping() // обновляет всё, что есть
    public AccountDto updateAccount(@RequestBody AccountDto accountDto){
        return new AccountDto();
    }

    @PatchMapping() // обновляет определённые поля
    public AccountDto updatePartialAccount(@RequestBody AccountDto accountDto){
        return new AccountDto();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}") // удаление аккаунта
    public void deleteAccount(@PathVariable Integer id){

    }
}
