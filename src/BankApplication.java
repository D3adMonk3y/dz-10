import excepcions.WrongAccountException;
import excepcions.WrongCurrencyException;
import excepcions.WrongOperationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankApplication {

    private final List<Account> accounts = new ArrayList<>() {{
        add(new Account("accountId001", 100, "USD"));
        add(new Account("accountId002", 500, "EUR"));
        add(new Account("accountId003", 250, "HRV"));
        add(new Account("accountId004", 1000, "USD"));
        add(new Account("accountId005", 750, "USD"));
        add(new Account("accountId006", 50, "USD"));
    }};


    public void process(String accountId, int amount, String currency) throws Exception {

        for(Account account: accounts){
            if(account.getId().equals(accountId)){
                if (account.getCurrency().equals(currency)){
                    if(account.getBalance() >= amount){
                        int randomInt = new Random().nextInt(2);
                        if(randomInt == 1){
                            throw new Exception();
                        }
                        account.setBalance(account.getBalance() - amount);
                        return;
                    }else {
                        throw new WrongOperationException();
                    }
                }else {
                    throw new WrongCurrencyException();
                }
            }
        }

        throw new WrongAccountException();
    }
}