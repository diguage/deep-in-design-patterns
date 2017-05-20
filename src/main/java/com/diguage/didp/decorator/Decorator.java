package com.diguage.didp.decorator;

/**
 * @author diguage
 * @since 2017-05-16
 */
public class Decorator extends Component {
  protected Component component;

  public void operation() {
    if (component != null) {
      component.operation();
    }
  }

  public void setComponent(Component component) {
    this.component = component;
  }
}
