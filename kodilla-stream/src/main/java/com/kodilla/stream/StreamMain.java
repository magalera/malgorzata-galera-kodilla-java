package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("capslook", (text -> text.toUpperCase()));
        poemBeautifier.beautify("emoticon", (text -> ":-)_" + text + "_(-:"));
        poemBeautifier.beautify("Beautiful tekst", (text -> "*&*&*&*&*&*" + text + "*&*&*&*&*&*"));
        poemBeautifier.beautify("rock and roll", (text -> "Rock&Roll"));
        poemBeautifier.beautify("Hello, how are you?", (text -> text + " ;-) :-D :-)"));
    }
}
