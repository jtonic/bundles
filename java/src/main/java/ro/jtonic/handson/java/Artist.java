package ro.jtonic.handson.java;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public final class Artist {

  private String name;
  private List<Artist> members;
  private String nationality;

  public Artist(String name, String nationality) {
    this(name, Collections.emptyList(), nationality);
  }

  public Artist(String name, List<Artist> members, String nationality) {
    Objects.requireNonNull(name);
    Objects.requireNonNull(members);
    Objects.requireNonNull(nationality);
    this.name = name;
    this.members = new ArrayList<>(members);
    this.nationality = nationality;
  }

  Stream<Artist> getMembers() {
    return members.stream();
  }

  public boolean isSolo() {
    return members.isEmpty();
  }

  public boolean isFrom(String nationality) {
    return this.nationality.equals(nationality);
  }

  @Override
  public String toString() {
    return getName();
  }

  private String getName() {
    return name;
  }

  public Artist copy() {
    List<Artist> members = getMembers().map(Artist::copy).collect(toList());
    return new Artist(name, members, nationality);
  }
}
