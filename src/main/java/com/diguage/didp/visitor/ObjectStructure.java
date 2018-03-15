package com.diguage.didp.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * ObjectStructure 类
 *
 * @author D瓜哥，https://www.diguage.com/
 * @since 2017-05-19 17:53:36
 */
public class ObjectStructure {
  private List<Element> elements = new ArrayList<>();

  public void attach(Element element) {
    elements.add(element);
  }

  public void detach(Element element) {
    elements.remove(element);
  }

  public void accept(Vistor vistor) {
    elements.forEach(e -> e.accept(vistor));
  }
}
