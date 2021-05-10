package com.sample.pc.sequencegenerator;

import java.io.Serializable;

public interface Identifiable<T extends Serializable> {

    T getId();
    T getPrefix();
    
}
