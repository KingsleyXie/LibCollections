package libcoll.libcollections;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class LibCollDBInterfacesTest {
    @Test
    public void testDB() {
        final LibCollDBInterfaces itfc = new LibCollDBInterfaces(
            InstrumentationRegistry.getTargetContext()
        );
        assertEquals(itfc.getCategories().size(), 16);
    }
}
