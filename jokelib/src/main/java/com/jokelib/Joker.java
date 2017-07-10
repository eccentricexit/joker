package com.jokelib;

import java.util.ArrayList;
import java.util.Collection;

public class Joker {

    private Collection<String> jokes;

    public Joker(){
        jokes = new ArrayList<>();
        jokes.add("A SQL query goes into a bar, walks up to two tables and asks, can I join you?");
        jokes.add("Endless Loop: n., see Loop, Endless.\n" +"Loop, Endless: n., see Endless Loop.");
        jokes.add("Why do programmers always get Christmas and Halloween mixed up? Because DEC " +
                "25 = OCT 31");
        jokes.add("C makes it easy to shoot yourself in the foot. C++ makes it harder, but when " +
                "you do, it blows away your whole leg.");
        jokes.add("Any sufficiently advanced bug is indistinguishable from a feature");
        jokes.add("COBOL programmers understand why women hate periods.");
        jokes.add("A computer scientist is someone who fixes things that aren't broken.");
    }

    public String getJoke() {
        return getRandomJoke();
    }

    private String getRandomJoke() {
        int num = (int) (Math.random() * jokes.size());
        for(String t: jokes) if (--num < 0) return t;
        throw new AssertionError();
    }
}
