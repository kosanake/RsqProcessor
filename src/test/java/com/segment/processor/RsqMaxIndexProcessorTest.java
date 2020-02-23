package com.segment.processor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RsqMaxIndexProcessorTest {
    int[] source;

    @Before
    public void setUp() throws Exception {
        source = new int[]{36, 118, 6, 24, 12, 344};
    }

    @Test
    public void query() {
        RsqMaxIndexProcessor rsqProcessor = new RsqMaxIndexProcessor(source);
        assertEquals((long)5, (long)rsqProcessor.query(1, source.length).getValue());
    }

    @Test
    public void modify() {
        RsqMaxIndexProcessor rsqProcessor = new RsqMaxIndexProcessor(source);
        rsqProcessor.modify(2, 39);
        assertEquals((long) 5, (long)rsqProcessor.query(1, source.length).getValue());
    }
}