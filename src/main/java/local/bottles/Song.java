package local.bottles;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Song {

    public String verse(int number) {
        return new Round(number).toString();
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
