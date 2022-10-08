package fhtw.bic.bic_summenrechner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SummenrechnerConrollerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldDeliverCorrectResult(){
        //Arrange
        int expectedResult=5;

        //Act
        int actualResult= testRestTemplate.getForObject("http://localhost:" + port + "/api/summenrechner?numberOne=2&numberTwo=3", Integer.class);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({"2,2,4", "-2,8,6","256,1024,1280"})
    public void SummenrechnerController_shoudReturnCorrectSum_AddIntegers(int numberOne, int numberTwo, long result){
        //Arrange
        int firstNumber= numberOne;
        int secondNUmber= numberTwo;
        long expectedResult = result;

        //Act
        int actualResult= testRestTemplate.getForObject("http://localhost:"+port+String.format("/api/summenrechner?numberOne=%s&numberTwo=%s", numberOne,numberTwo), Integer.class);

        //Assert
        assertEquals(expectedResult,actualResult);
    }



}