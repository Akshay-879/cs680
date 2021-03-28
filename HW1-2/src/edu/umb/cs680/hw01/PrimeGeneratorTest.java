package edu.umb.cs680.hw01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {

    @Test
    public void primeGeneratorfrom25to35() {
        PrimeGenerator gen = new PrimeGenerator(25, 35);
        Long[] ExpectedPrimeNumbers = new Long[]{29L, 31L};
        gen.generatePrimes();
        assertArrayEquals(ExpectedPrimeNumbers, gen.getPrimes().toArray() );
    }



    @Test
    public void primeGeneratorfrom1to20() {
        PrimeGenerator gen = new PrimeGenerator(1, 20);
        Long[] ExpectedPrimeNumbers = new Long[]{2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L};
        gen.generatePrimes();
        assertArrayEquals(ExpectedPrimeNumbers, gen.getPrimes().toArray());
    }



    @Test
    public void primeGeneratorfrom5to5() {
        long from = 5;
        long to = 5;
        try{
            PrimeGenerator gen = new PrimeGenerator(from, to);
            Long[] ExpectedPrimeNumbers = new Long[]{};
            gen.generatePrimes();
            assertArrayEquals(ExpectedPrimeNumbers, gen.getPrimes().toArray());
        }
        catch(RuntimeException ex){
            assertEquals("Wrong input values: from=" + from + " to=" + to,ex.getMessage());
            //System.out.println(ex.getMessage());
        }
    }



    @Test
    public void primeGeneratornegative() {
        long from = -5;
        long to = 5;
        try{
            PrimeGenerator gen = new PrimeGenerator(from, to);
            Long[] ExpectedPrimeNumbers = {};
            gen.generatePrimes();
            assertArrayEquals(ExpectedPrimeNumbers, gen.getPrimes().toArray());
        }
        catch(RuntimeException ex){
            assertEquals("Wrong input values: from=" + from + " to=" + to,ex.getMessage());
            //System.out.println(ex.getMessage());
        }
    }



    @Test
    public void primeGeneratorfrom100to10() {
        long from = 100;
        long to = 10;
        try{
            PrimeGenerator gen = new PrimeGenerator(from, to);
            Long[] ExpectedPrimeNumbers = {};
            gen.generatePrimes();
            assertArrayEquals( ExpectedPrimeNumbers, gen.getPrimes().toArray() );
        }
        catch(RuntimeException ex){
            assertEquals("Wrong input values: from=" + from + " to=" + to,ex.getMessage());
            //System.out.println(ex.getMessage());
        }
    }
}