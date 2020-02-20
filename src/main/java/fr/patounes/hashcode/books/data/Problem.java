package fr.patounes.hashcode.books.data;

import java.util.LinkedList;
import java.util.List;

public class Problem {
    private int nbBooks;
    private int nbLibraries;
    private int duration;
    private List<Library> libraries;

    public Problem(int nbBooks, int nbLibraries, int duration) {
        this.nbBooks = nbBooks;
        this.nbLibraries = nbLibraries;
        this.duration = duration;
        libraries = new LinkedList<>();
    }

    public int getNbBooks() {
        return nbBooks;
    }

    public void setNbBooks(int nbBooks) {
        this.nbBooks = nbBooks;
    }

    public int getNbLibraries() {
        return nbLibraries;
    }

    public void setNbLibraries(int nbLibraries) {
        this.nbLibraries = nbLibraries;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void addLibrary(Library library) {
        libraries.add(library);
    }

    public Library getLibrary(int index) {
        return this.libraries.get(index);
    }

    @Override
    public String toString() {
        return "Problem{" +
                "nbBooks=" + nbBooks +
                ", nbLibraries=" + nbLibraries +
                ", duration=" + duration +
                ", libraries=" + libraries +
                '}';
    }
}
