package ro.jtonic.handson.java;

import static java.util.stream.Stream.concat;

import java.util.stream.Stream;

public interface Performance {

    String getName();

    Stream<Artist> getMusicians();

    default Stream<Artist> getAllMusicians() {
        return getMusicians().flatMap(artist -> concat(Stream.of(artist), artist.getMembers()));
    }
}
