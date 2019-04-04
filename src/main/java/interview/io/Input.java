package interview.io;

import interview.model.PhoneData;

public interface Input {
    PhoneData readNext();
    
    boolean hasNext();
    
    void close();
}
