package local.bottles;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Song {
    private final static Lyrics NO_MORE = (verse) ->
            "No more bottles of beer on the wall, no more bottles of beer.\n" +
                    "Go to the store and buy some more, 99 bottles of beer on the wall.\n";

    private final static Lyrics LAST_ONE = (verse) ->
            "1 bottle of beer on the wall, 1 bottle of beer.\n" +
                    "Take it down and pass it around, no more bottles of beer on the wall.\n";

    private final static Lyrics PENULTIMATE = (verse) ->
            "2 bottles of beer on the wall, 2 bottles of beer.\n" +
                    "Take one down and pass it around, 1 bottle of beer on the wall.\n";

    private final static Lyrics DEFAULT = (verse) ->
            verse.getNumber() + " bottles of beer on the wall, " + verse.getNumber() + " bottles of beer.\n" +
                    "Take one down and pass it around, " + (verse.getNumber() - 1) + " bottles of beer on the wall.\n";


    public String verse(int number) {
        return verse_for(number).text();
    }

    public String verses(int starting, int ending) {
        return IntStream
                .rangeClosed(ending, starting).boxed().sorted(Collections.reverseOrder())
                .map(this::verse).collect(Collectors.joining("\n"));
    }

    public String whole() {
        return verses(99, 0);
    }

    private Verse verse_for(int number) {
        Verse result;
        switch (number) {
            case (0):
                result = new Verse(number, NO_MORE);
                break;
            case (1):
                result = new Verse(number, LAST_ONE);
                break;
            case (2):
                result = new Verse(number, PENULTIMATE);
                break;
            default:
                result = new Verse(number, DEFAULT);
        }

        return result;
    }
}
