package com.segment.processor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RsqSegmentProcessorTest {

    int[] source;

    @Before
    public void setUp() throws Exception {
        source = new int[]{2, 7, 6, 4, 1, 3};
    }

    @Test
    public void shouldQuery() {
        RsqSegmentProcessor rsqProcessor = new RsqSegmentProcessor(source);
        assertEquals(23, rsqProcessor.query(1, source.length));
        assertEquals(18, rsqProcessor.query(2, 5));
        assertEquals(2, rsqProcessor.query(1, 1));
        assertEquals(3, rsqProcessor.query(source.length, source.length));
    }

    @Test
    public void shouldModify() {
        RsqSegmentProcessor rsqProcessor = new RsqSegmentProcessor(source);
        assertEquals(23, rsqProcessor.query(1, source.length));
        rsqProcessor.modify(2, 5, 2);
        assertEquals(31, rsqProcessor.query(1, source.length));
    }
}