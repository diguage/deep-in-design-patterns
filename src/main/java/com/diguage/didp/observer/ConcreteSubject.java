package com.diguage.didp.observer;

/**
 * ConcreteSubject 类
 *
 * @author D瓜哥，http://www.diguage.com/
 * @since 2017-05-23 10:18:27
 */
public class ConcreteSubject extends Subject {
  private String subjectState;

  public String getSubjectState() {
    return subjectState;
  }

  public void setSubjectState(String subjectState) {
    this.subjectState = subjectState;
  }
}
