package app.pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;

@Component
public class PersonHandler {

    @Autowired
    private SafeHandler safeHandler;

    public void handlePerson(Person person) {
        System.out.println(Thread.currentThread().getId() + "\t in PersonHandler :"+person.getName());

        for(SafeDeposit safe: person.getSafeDepositAccessList())
        {

            Executors.newCachedThreadPool().execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getId()+"\t safe will be handled :"+ person.getName() +" - " + safe.getId());
                    safeHandler.calculate(safe, person);

                }
            });
        }


    }
}
