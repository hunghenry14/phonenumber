package interview.io;

import interview.model.PhoneData;

public interface Output {
    void write(PhoneData data);
    
    void close();
}
