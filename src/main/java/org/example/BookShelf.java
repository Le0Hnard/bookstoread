package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookShelf {

    private List<String> bookShelf;

    public List<String> books() {
        this.bookShelf = new ArrayList<String>();
        return this.bookShelf;
    }

}
