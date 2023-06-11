package pl.edu.agh.to.lab4;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PrisonersDatabase implements SuspectAggregate{

    private final Map<String, Collection<Prisoner>> prisoners = new HashMap<String, Collection<Prisoner>>();

    public PrisonersDatabase() {
    }

    public Map<String, Collection<Prisoner>> findAll() {
        return prisoners;
    }

    public Collection<String> getAllPrisons() {
        return prisoners.keySet();
    }

    void addPrisoner(String category, Prisoner prisoner) {
        if (!prisoners.containsKey(category))
            prisoners.put(category, new ArrayList<Prisoner>());
        prisoners.get(category).add(prisoner);
    }

    public static String render(Prisoner prisoner) {
        return prisoner.getName() + " " + prisoner.getSurname();
    }

    @Override
    public Iterator<Suspect> iterator(Predicate<Suspect> filter) {
        Iterator<Prisoner> prisonerIterator = prisoners.values().stream()
                .flatMap(Collection::stream)
                .toList()
                .iterator();
        return new SuspectIterator(prisonerIterator, filter);
    }
}
