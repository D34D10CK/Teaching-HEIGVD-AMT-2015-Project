package ch.heigvd.amt.amtproject.services;

import javax.ejb.Local;

@Local
public interface TestDataManagerLocal {

    void generateTestData();
    
}
