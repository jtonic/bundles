package ro.jtonic.handson.java;

import lombok.Getter;

public final class Track {

    @Getter
    private final String name;
    private final int length;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public Track copy() {
        return new Track(name, length);
    }
}
