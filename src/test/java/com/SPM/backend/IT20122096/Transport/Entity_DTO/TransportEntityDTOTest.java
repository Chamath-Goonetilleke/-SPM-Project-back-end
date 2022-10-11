package com.SPM.backend.IT20122096.Transport.Entity_DTO;

import com.SPM.backend.IT20122096.Transport.DTO.TransportDTO;
import com.SPM.backend.IT20122096.Transport.Entity.Transport;
import com.SPM.backend.IT20122096.Transport.Entity.Vehicle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.meanbean.test.BeanTester;
import org.springframework.boot.test.context.SpringBootTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class TransportEntityDTOTest {
    @Test
    void TestAllTransportEntities(){
        BeanTester beanTester = new BeanTester();
        beanTester.testBean(Transport.class);
    }
    @Test
    void TestAllTransportDTOs(){
        BeanTester beanTester = new BeanTester();
        beanTester.testBean(TransportDTO.class);
    }
}
