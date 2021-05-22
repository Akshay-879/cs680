package edu.umb.cs680.hw12;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<ApfsElement> {

    @Override
    public int compare(ApfsElement f1, ApfsElement f2) {
        return f1.getName().compareTo(f2.getName());
    }

}
