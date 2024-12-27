package org.example.observable;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Observable {
  private final List<Observer> observers = new CopyOnWriteArrayList<>();

  public void addObserver(Observer observer) {
    if (observer != null && !observers.contains(observer)) {
      observers.add(observer);
    }
  }

  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  protected void notifyObservers(String message) {
    for (Observer observer : observers) {
      observer.update(message);
    }
  }
}
