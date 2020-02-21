package com.segment.processor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RsqMaxProcessorTest {

    int[] source;

    @Before
    public void setUp() throws Exception {
        source = new int[]{36, 18, 6, 24, 12, 3};
    }

    @Test
    public void query() {
        RsqMaxProcessor rsqProcessor = new RsqMaxProcessor(source);
        assertEquals(36, rsqProcessor.query(1, source.length));
        assertEquals(24, rsqProcessor.query(2, 5));
        assertEquals(36, rsqProcessor.query(1, 1));
        assertEquals(3, rsqProcessor.query(source.length, source.length));
    }

    @Test
    public void modify() {
        RsqMaxProcessor rsqProcessor = new RsqMaxProcessor(source);
        rsqProcessor.modify(1, 3);
        assertEquals(24, rsqProcessor.query(1, source.length));
    }
}