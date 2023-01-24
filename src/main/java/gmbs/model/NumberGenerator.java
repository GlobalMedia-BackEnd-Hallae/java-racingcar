package gmbs.model;

@FunctionalInterface
public interface NumberGenerator {

    int generate(int rangeStart, int rangeEnd);
}
