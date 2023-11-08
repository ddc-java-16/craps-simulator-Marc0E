package edu.cnm.deepdive.craps;

import edu.cnm.deepdive.craps.model.Round;
import edu.cnm.deepdive.craps.model.Round.State;
import java.util.EnumMap;
import java.util.Map;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {
    Map<State, Long> tallies = new EnumMap<>(State.class);
    RandomGenerator rng = RandomGenerator.getDefault();
    Stream.generate(() -> new Round().play(rng))
        .limit(1_000_000_000)
        .forEach((state) -> tallies.put(state, 1 + tallies.getOrDefault(state,0L)));
    System.out.println(tallies);
  }
}
