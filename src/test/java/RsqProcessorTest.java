import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RsqProcessorTest {

    @Test
    public void shouldQuery() {
        int[] source = new int[]{2, 7, 6, 4, 1, 3};
        RsqProcessor rsqProcessor = new RsqProcessor(source);
        assertEquals(23, rsqProcessor.query(1, source.length));
        assertEquals(18, rsqProcessor.query(2, 5));
        assertEquals(2, rsqProcessor.query(1, 1));
        assertEquals(3, rsqProcessor.query(source.length, source.length));
    }
}