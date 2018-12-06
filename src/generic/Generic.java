package generic;

import base.Base;

public interface Generic<T extends Base> {
    double total(T object);
}
