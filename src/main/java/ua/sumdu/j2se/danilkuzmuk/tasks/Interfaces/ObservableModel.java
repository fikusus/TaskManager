package ua.sumdu.j2se.danilkuzmuk.tasks.Interfaces;

public interface ObservableModel {
    void registerObserver(ObserverView o);
    void removeObserver(ObserverView o);
    void notifyObservers();
}
