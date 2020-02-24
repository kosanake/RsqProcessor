package com.segment.processor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RsqSumProcessorTest {

    int[] source;

    @Before
    public void setUp() throws Exception {
        source = new int[]{2, 7, 6, 4, 1, 3};
    }

    @Test
    public void shouldQuery() {
        RsqSumProcessor rsqSumProcessor = new RsqSumProcessor(source);
        assertEquals(23, rsqSumProcessor.query(1, source.length));
        assertEquals(18, rsqSumProcessor.query(2, 5));
        assertEquals(2, rsqSumProcessor.query(1, 1));
        assertEquals(3, rsqSumProcessor.query(source.length, source.length));
    }

    @Test
    public void shouldModify() {
        RsqSumProcessor rsqSumProcessor = new RsqSumProcessor(source);
        rsqSumProcessor.modify(2, 2);
        assertEquals(18, rsqSumProcessor.query(1, source.length));
    }
}