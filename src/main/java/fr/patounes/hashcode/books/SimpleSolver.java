package fr.patounes.hashcode.books;

import fr.patounes.hashcode.books.data.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SimpleSolver implements BookSolver {

    private Library onSignup;
    private int signupIndex;
    private int signupDays;
    private List<Library> signup;
    private Map<Integer, Integer> nbScannedPerLibrary;

    public SimpleSolver() {
        onSignup = null;
        signupIndex = 0;
        signupDays = 0;
        signup = new LinkedList<>();
        nbScannedPerLibrary = new HashMap<>();
    }

    private void signup(Problem problem) {
        if (signupIndex < problem.getNbLibraries()) {
            if (onSignup == null) {
                onSignup = problem.getLibrary(signupIndex);
            }
            signupDays++;
            if (signupDays == onSignup.getSignupDuration()) {
                signup.add(onSignup);
                nbScannedPerLibrary.put(onSignup.getId(), 0);
                signupIndex++;
                signupDays = 0;
                onSignup = null;
            }
        }
    }

    private void scan(Problem problem) {
        for(Library library: signup) {
            int parallelism = library.getNbParallelScanning();
            int scannedAlready = nbScannedPerLibrary.get(library.getId());
            nbScannedPerLibrary.put(library.getId(), Math.min(scannedAlready + parallelism, library.getNbBooks()));
        }
    }


    @Override
    public Output solve(Problem problem) {
        // solve
        for(int jour = 0; jour < problem.getDuration() - 1; jour++) {
            signup(problem);
            scan(problem);
        }
        // write
        /*System.out.println(signup);
        System.out.println(nbScannedPerLibrary);*/
        int nbLibraries = signup.size();
        List<OutputLibrary> libraries = new LinkedList<>();

        for(Library library: signup) {
            int id = library.getId();
            int nbToScan = nbScannedPerLibrary.get(id);
            List<Book> books = new LinkedList<>();

            int cpt = 0;
            for(Book book: library.getBooks()) {
                if (cpt >= nbToScan) {
                    break;
                }
                books.add(book);
                cpt++;
            }
            libraries.add(new OutputLibrary(id, nbToScan, books));
        }

        return new Output(nbLibraries, libraries);
    }
}
