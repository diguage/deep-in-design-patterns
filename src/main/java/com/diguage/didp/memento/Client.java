package com.diguage.didp.memento;

/**
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-26
 */
public class Client {
  public static void main(String[] args) {
    Originator originator = new Originator();
    originator.setState("On");
    originator.show();


    Caretaker caretaker = new Caretaker();
    caretaker.setMemento(originator.createMemento());

    originator.setState("Off");
    originator.show();

    originator.setMemento(caretaker.getMemento());
    originator.show();
  }
}
