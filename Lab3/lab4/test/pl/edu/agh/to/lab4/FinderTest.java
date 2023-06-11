package pl.edu.agh.to.lab4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FinderTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private PrintStream originalOut;

    private PersonDataProvider personDataProvider;

    private PrisonersDatabase prisonersDatabase;

    private Finder suspectFinder;
    @Before
    public void setUp() {
        personDataProvider = new PersonDataProvider();
        prisonersDatabase = new PrisonersDatabase();
        suspectFinder = new Finder(new CompositeAggregate(List.of(personDataProvider, prisonersDatabase)));
    }
    @Test
    public void testDisplayingNotJailedPrisoner() {
        prisonersDatabase.addPrisoner("Wiezeienie stanowe", new Prisoner("Jan", "Kowalski",44, "802104543357", 2000, 1));
        suspectFinder.display(new CompositeSearchStrategy(Collections.singletonList(new NameSearchStrategy("Jan"))));
        assertContentIsDisplayed("Jan Kowalski");
    }

    @Test
    public void testDisplayingSuspectedPerson() {
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Jan", "Kowalski", 20));
        suspectFinder.display(new CompositeSearchStrategy(Collections.singletonList(new NameSearchStrategy("Jan"))));
        assertContentIsDisplayed("Jan Kowalski");    }

    @Test
    public void testNotDisplayingTooYoungPerson() {
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Jan", "Kowalski", 15));
        suspectFinder.display(new CompositeSearchStrategy(Collections.singletonList(new NameSearchStrategy("Jan"))));
        assertContentIsNotDisplayed("Jan Kowalski");    }

    @Test
    public void testNotDisplayingJailedPrisoner() {
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Jan", "Kowalski", 20));
        prisonersDatabase.addPrisoner("Wiezeienie stanowe", new Prisoner("Dariusz", "Kowalski", 29,"802104543357", 2000, 20));
        suspectFinder.display(new CompositeSearchStrategy(Collections.singletonList(new NameSearchStrategy("Jan"))));
        assertContentIsNotDisplayed("Dariusz Kowalski");
    }

    private void assertContentIsDisplayed(String expectedContent) {
        assertTrue("Application did not contain expected content: " + outContent.toString(), outContent.toString()
                .contains(expectedContent));
    }

    private void assertContentIsNotDisplayed(String expectedContent) {
        assertFalse("Application did contain expected content although it should not: " + outContent.toString(), outContent.toString()
                .contains(expectedContent));
    }

    @Before
    public void redirectSystemOut() {
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void resetSystemOut() {
        System.setOut(originalOut);
    }

}
