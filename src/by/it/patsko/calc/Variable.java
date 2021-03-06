package by.it.patsko.calc;

import java.util.HashMap;
import java.util.Map;

class Variable extends Var {
    private String key;
    private Var value;
    static Map<String, Var> map = new HashMap<>();

    Variable(String key) {
        this.key = key;
    }

    Variable(String key, Var value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Var getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.key+"="+this.value;
    }

    @Override
    public Var assign(Var other) throws CalcException {
        if (other instanceof Scalar || other instanceof Vector || other instanceof Matrix) {
            map.put(key, other);
            return new Variable(key, map.get(key));
        } else throw new CalcException("");
    }

}
