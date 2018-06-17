package local.bottles;

import org.apache.commons.lang3.StringUtils;

class Round {
    private int bottles;

    Round(int bottles) {
        this.bottles = bottles;
    }

    public String toString() {
        return challenge() + response();
    }

    private String challenge() {
        return StringUtils.capitalize(bottlesOfBeer()) + " " + onWall() + ", " + bottlesOfBeer() + ".\n";
    }

    private String response() {
        return goToTheStoreOrTakeOneDown() + ", " + bottlesOfBeer() + " " + onWall() + ".\n";
    }

    private String bottlesOfBeer() {
        return anglicizedBottleCount() + " " + pluralizedBottleCount() + " of " + beer();
    }

    private String onWall() {
        return "on the wall";
    }

    private String beer() {
        return "beer";
    }

    private String pluralizedBottleCount() {
        return isLastBeer() ? "bottle" : "bottles";
    }

    private String anglicizedBottleCount() {
        return isAllOut() ? "no more" : "" + bottles;
    }

    private String goToTheStoreOrTakeOneDown() {
        if (isAllOut()) {
            bottles = 99;
            return buyNewBeer();
        } else {
            String lyrics = drinkBeer();
            bottles -= 1;
            return lyrics;
        }
    }

    private String buyNewBeer() {
        return "Go to the store and buy some more";
    }

    private String drinkBeer() {
        return "Take " + itOrOne() + " down and pass it around";
    }

    private String itOrOne() {
        return isLastBeer() ? "it" : "one";
    }

    private boolean isAllOut() {
        return bottles == 0;
    }

    private boolean isLastBeer() {
        return bottles == 1;
    }
}
