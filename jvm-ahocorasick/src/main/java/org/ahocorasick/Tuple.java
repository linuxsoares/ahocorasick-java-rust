package org.ahocorasick;

import java.io.Serializable;

public class Tuple< K, V > implements Serializable {
    K key;
    V value;

    public Tuple(K key, V value){
        this.key   = key;
        this.value = value;
    }

    public Tuple(Tuple< K, V> tuple) {
        this.key   = tuple.getKey();
        this.value = tuple.getValue();
    }

    public K getKey()   {
        return this.key;
    }
    public V getValue() {
        return this.value;
    }

    public boolean equals( Object o ) {
        if( !( o instanceof Tuple ) )
            return false;

        @SuppressWarnings( "unchecked" )
        Tuple< K, V > tuple = ( Tuple< K, V > ) o;
        K             key   = tuple.getKey();
        V             value = tuple.getValue();

        return ((key == this.key && value == this.value) || key.equals(this.key) && value.equals(this.value));
    }
}
