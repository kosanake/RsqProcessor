package com.segment.processor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RsqZeroCountProcessorTest {

    int[] source;

    @Before
    public void setUp() throws Exception {
        source = new int[]{2, 0, 6, 0, 1, 0};
    }

    @Test
    public void shouldQuery() {
        RsqZeroCountProcessor rsqZeroCountProcessor = new RsqZeroCountProcessor(source);
        assertEquals(3, rsqZeroCountProcessor.query(1, source.length));
        assertEquals(2, rsqZeroCountProcessor.query(2, 5));
        assertEquals(0, rsqZeroCountProcessor.query(1, 1));
        assertEquals(1, rsqZeroCountProcessor.query(source.length, source.length));
    }

    @Test
    public void shouldModify() {
        RsqZeroCountProcessor rsqZeroCountProcessor = new RsqZeroCountProcessor(source);
        rsqZeroCountProcessor.modify(3, 0);
        assertEquals(4, rsqZeroCountProcessor.query(1, source.length));
    }
}