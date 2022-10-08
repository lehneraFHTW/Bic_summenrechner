package fhtw.bic.bic_summenrechner;

import org.junit.jupiter.api.Test;
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


}