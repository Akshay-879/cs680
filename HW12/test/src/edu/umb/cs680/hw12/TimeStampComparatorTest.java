package edu.umb.cs680.hw12;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;


public class TimeStampComparatorTest {

    APFS fs;

    private void before() {
        fs = APFS.getFileSystem();

        ApfsDirectory root = new ApfsDirectory("root", 0, "Akshay", LocalDateTime.of(2020, 05, 21, 3, 0), null, null);
        ApfsDirectory system = new ApfsDirectory("system", 0, "Akshay", LocalDateTime.of(2020, 05, 21, 3, 0), null, root);
        ApfsDirectory home = new ApfsDirectory("home", 0, "Akshay", LocalDateTime.of(2020, 05, 21, 3, 0), null, root);
        ApfsDirectory picture = new ApfsDirectory("picture", 0, "Akshay", LocalDateTime.of(2020, 05, 21, 3, 0), null, home);
        home.appendChild(picture);
        root.appendChild(home);
        root.appendChild(system);

        ApfsFile a = new ApfsFile("a", 100, "Akshay", LocalDateTime.of(2020, 05, 21, 3, 0), null, system);
        ApfsFile b = new ApfsFile("b", 200, "Akshay", LocalDateTime.of(2020, 05, 21, 3, 0), null, system);
        ApfsFile c = new ApfsFile("c", 100, "Akshay", LocalDateTime.of(2020, 05, 21, 3, 0), null, system);
        system.appendChild(a);
        system.appendChild(b);
        system.appendChild(c);

        ApfsFile d = new ApfsFile("d", 400, "Akshay", LocalDateTime.of(2020, 05, 21, 3, 0), null, home);
        ApfsFile e = new ApfsFile("e", 500, "Akshay", LocalDateTime.of(2020, 05, 21, 3, 0), null, picture);
        ApfsFile f = new ApfsFile("f", 100, "Akshay", LocalDateTime.of(2020, 05, 21, 3, 0), null, picture);
        ApfsElement x = new ApfsLink("x", 0, "Akshay", LocalDateTime.of(2020, 05, 21, 3, 0), null, system, home);
        ApfsElement y = new ApfsLink("y", 0, "Akshay", LocalDateTime.of(2020, 05, 21, 3, 0), null, picture, e);

        picture.appendChild(y);
        picture.appendChild(e);
        picture.appendChild(f);
        fs.setRoot(root);
        home.appendChild(x);
        home.appendChild(d);

    }

    @Test
    public void testLinkEquality() {
        before();
        LinkedList<ApfsElement> l1 = ((ApfsDirectory)fs.getRoot()).getChildren();
        String str = l1.getFirst().getName();
        LinkedList<ApfsElement> l2 = ((ApfsDirectory)fs.getRoot()).getChildren(new TimeStampComparator());
        String str1 = l2.getLast().getName();
        assertNotEquals(str, str1);
    }

}