package com.example.javajokes;

import java.util.Random;

public class Joker {
    // randomly copied from http://jokes.cc.com/
    private String[] jokes =
            {"I can't believe I made it anywhere creatively, though, because I was raised by two " +
                    "loving and supportive parents. Nothing squashes creativity more than " +
                    "unconditional love and support from a functional household. If you have kids, " +
                    "sh*t on their dreams a little bit.",
            "Q: Why can't a blonde dial 911?\n" +
                    "\n" +
                    "A: She can't find the eleven.",
            "Q: What did the blonde customer say after reading the buxom waitress's name tag?\n" +
                    "\n" +
                    "A: \"What did you name the other one?\"",
            "Q: What do you call a blonde who has dyed her hair brown?\n" +
                    "\n" +
                    "A: Artificial intelligence.",
            "How do two psychiatrists greet each other?\n" +
                    "\n" +
                    "\"You are fine, how am I?\"",
            "I really don't like living there; I have to for health reasons. I'm very paranoid, " +
                    "and New York's the only place where my fears are justified.",
            "I think you know when you have to go on a diet: when you go bungee jumping, " +
                    "and you pull the bridge down with you.",
            "Q: How many psychiatrists does it take to screw in a light bulb?\n" +
                    "\n" +
                    "A: One, but it takes five sessions.",
            "Joe asked God, \"How much is a penny worth in heaven?\"\n" +
                    "\n" +
                    "God replied, \"$1 million.\"\n" +
                    "\n" +
                    "Joe asked, \"How long is a minute in heaven?\"\n" +
                    "\n" +
                    "God said, \"One million years.\"\n" +
                    "\n" +
                    "Joe asked for a penny.\n" +
                    "\n" +
                    "God said, \"Sure, in a minute.\"",
            "Now what I don't get are these people who, instead of buying a four-pack or an " +
                    "eight-pack of toilet paper, they buy the single individual roll. " +
                    "Are you trying to quit?"};

    public String getJoke() {
        // return a random joke from the jokes array
        return jokes[new Random().nextInt(jokes.length)];
    }
}
