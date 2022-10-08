package fhtw.bic.bic_summenrechner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummenrechnerConroller {

    private Summenrechner rechner = new Summenrechner();

    @GetMapping("/api/summenrechner")
    public long addNumbers(@RequestParam(name="numberOne") int numberOne, @RequestParam(name="numberTwo") int numberTwo){
        return rechner.add(numberOne,numberTwo);
    }

}
