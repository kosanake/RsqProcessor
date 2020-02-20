package com.segment.processor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RsqGreatestCommonDevisorProcessorTest {

    int[] source;

    @Before
    public void setUp() throws Exception {
        source = new int[]{36, 18, 6, 24, 12, 3};
    }

    @Test
    public void shouldGcd() {
        int gcd = RsqGreatestCommonDevisorProcessor.gcd(16, 4);
        assertEquals(gcd, 4);
    }

    @Test
    public void shouldQuery() {
        RsqGreatestCommonDevisorProcessor rsqProcessor = new RsqGreatestCommonDevisorProcessor(source);
        assertEquals(3, rsqProcessor.query(1, source.length));
        assertEquals(6, rsqProcessor.query(2, 5));
        assertEquals(36, rsqProcessor.query(1, 1));
        assertEquals(3, rsqProcessor.query(source.length, source.length));
    }

    @Test
    public void shouldModify() {
        RsqGreatestCommonDevisorProcessor rsqProcessor = new RsqGreatestCommonDevisorProcessor(source);
        rsqProcessor.modify(6, 6);
        assertEquals(6, rsqProcessor.query(1, source.length));
    }
}