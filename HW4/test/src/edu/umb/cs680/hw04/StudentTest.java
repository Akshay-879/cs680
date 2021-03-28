package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testcreateInStateStudent() {
        StudentStatus expected_status = StudentStatus.INSTATE;

        Student s =  Student.createInStateStudent("Carl", "Tetlow Street");
        assertEquals(expected_status, s.getStatus());

    }
    @Test
    void testcreateOutStateStudent() {
        StudentStatus expected_status = StudentStatus.OUTSTATE;
        Student s =  Student.createOutStateStudent("Jhon", "Texas", 7);
        assertEquals(expected_status, s.getStatus());
    }

    @Test
    void testcreateIntlStudent() {
        StudentStatus expected_status = StudentStatus.INTL;
        Student s =  Student.createIntlStudent("Akshay", "Harbour Point", 879,"Mumbai");
        assertEquals(expected_status, s.getStatus());
    }
}