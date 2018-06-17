package local.bottles;

class Verse {
    private int number;
    private Lyrics lyrics;

    Verse(int number, Lyrics lyrics) {
        this.number = number;
        this.lyrics = lyrics;
    }

    int getNumber() {
        return number;
    }

    String text() {
        return lyrics.apply(this);
    }
}
