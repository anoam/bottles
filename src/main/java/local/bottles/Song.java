package local.bottles;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Song {

    public String verse(int number) {
        return (number == 0 ? "No more" : number) + " bottle" + (number != 1 ? "s" : "") + " of beer on the wall, " +
                (number == 0 ? "no more" : number) + " bottle" + (number != 1 ? "s" : "") + " of beer.\n" +
                (number > 0 ? "Take " + (number > 1 ? "one" : "it") + " down and pass it around" : "Go to the store and buy some more") + ", " +
                (number - 1 < 0 ? 99 : (number - 1 == 0 ? "no more" : number - 1)) + " bottle" + (number - 1 != 1 ? "s" : "") +
                " of beer on the wall.\n";

    }

    public String verses(int starting, int ending) {
        return IntStream
                .rangeClosed(ending, starting).boxed().sorted(Collections.reverseOrder())
                .map(this::verse).collect(Collectors.joining("\n"));
    }

    public String whole() {
        return verses(99, 0);
    }
}
