package generic;

import base.Base;

public abstract class GenericBase<T extends Base> implements Generic<T> {

    @Override
    public double total(T object) {
        return object.getAmount();
    }
}
