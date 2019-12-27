package com.felix;

public class Checker implements Comparable<Checker.Player> {

    @Override
    public int compareTo(Player o) {
        return 0;
    }

    public int compare(Player a, Player b) {
        if (a.score == b.score) {
            return a.name.compareTo(b.name);
        }

        return b.score - a.score;
    }

    class Player {
        int score;
        String name;
    }
}
