package com.deep.random;

public class NumberToOrdinal {

    public static String numberToOrdinal( Integer number ) {

        String ordinalSuffix = "";
        if (number == null) {
            return ordinalSuffix;
        }

        int modOf10 = number % 10;
        int modOf100 = number % 100;

        if ((modOf100 - modOf10) == 10) {
            ordinalSuffix = "th";
        } else {
            ordinalSuffix = getOrdinalSuffix(number);
        }

        return number + ordinalSuffix;
    }

    private static String getOrdinalSuffix(Integer number) {
        int modOf10 = number % 10;
        switch (modOf10) {
            case 1 : return "st";
            case 2 : return "nd";
            case 3 : return "rd";
            default: return "th";
        }
    }

    public static void main(String[] args) {
        System.out.println(numberToOrdinal(11));
        System.out.println(numberToOrdinal(22));
        System.out.println(numberToOrdinal(92));
    }
}
