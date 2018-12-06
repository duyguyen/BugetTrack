package test_generic;

public class Predicate implements Generic<Integer>{
    @Override
    public boolean test(Integer obj) {
        return obj % 2 != 0;
    }
}
