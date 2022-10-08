package fhtw.bic.bic_summenrechner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SummenrechnerTest {

    @Test
    public static void checkAdd(){
        //Arrange
        Summenrechner rechner = new Summenrechner();
        //Act
        long summe = rechner.add(2,2);
        //Assert
        assertEquals(4,summe);

    }

    @ParameterizedTest
    @CsvSource({"2,2,4", "-2,8,6","256,1024,1280"})
    public void SummenrechnerController_shoudReturnCorrectSum_AddIntegers(int numberOne, int numberTwo, long result){
        //Arrange
        Summenrechner rechner = new Summenrechner();
        int firstNumber= numberOne;
        int secondNUmber= numberTwo;
        long expectedResult = result;

        //Act
        long actualResult= rechner.add(numberOne,numberTwo);

        //Assert
        assertEquals(expectedResult,actualResult);
    }

}