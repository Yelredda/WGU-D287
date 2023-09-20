package com.example.demo.repositories;

import com.example.demo.domain.InhousePart;
import com.example.demo.service.PartServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Project: demo
 * Package: com.example.demo.repositories
 * <p>
 * User: carolyn.sher
 * Date: 5/3/2022
 * Time: 11:33 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
class InhousePartRepositoryTest {
    InhousePartRepository inhousePartRepository;
    @BeforeEach
    void setUp() {
        inhousePartRepository=mock(InhousePartRepository.class);
    }
    @Test
    void findAll() {
        InhousePart part=new InhousePart();
        List partData=new ArrayList();
        partData.add(part);
        when(inhousePartRepository.findAll()).thenReturn(partData);
        List<InhousePart> parts=(List<InhousePart>)inhousePartRepository.findAll();
        assertEquals(partData.size(),1);
    }
}