package lesson19.HW19BankAccoutOperations;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;

public class AccountRunner {

    public static void main(String[] args) throws IllegalAccessException {

        //Account myAccount = new Account();

//        myAccount.deposit(BigDecimal.valueOf(500));
//        System.out.println(myAccount.getBalance());

        Class<Account> myAccount = Account.class;
//        Constructor<?>[] accauntConstructors = myAccount.getConstructors();
//        System.out.println(Arrays.toString(accauntConstructors));


        Field[] accountDeclaredFields = myAccount.getDeclaredFields();
        System.out.println(Arrays.toString(accountDeclaredFields));

        Field operationField = accountDeclaredFields[0];
        operationField.setAccessible(true);
        operationField.set(myAccount, BigDecimal.valueOf(500));

    }
}
