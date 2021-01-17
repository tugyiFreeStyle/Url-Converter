package com.trendyol.convertlink.domain.link;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShortLinkCodeGenerator {
    private static final char[] alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase().toCharArray();

    private ShortLinkCodeGenerator() {
    }

    //This could be very optimized to regarding article
    // https://medium.com/swlh/how-to-build-a-tiny-url-service-that-scales-to-billions-f6fb5ea22e8c
    public static String generateRandom() {
        Random rnd = new Random();

        List<String> result = IntStream.range(0, 10).boxed().map(i -> Character.toString(alphaNumericString[rnd.nextInt(25)]))
                .collect(Collectors.toList());

        return String.join("", result);
    }
}
