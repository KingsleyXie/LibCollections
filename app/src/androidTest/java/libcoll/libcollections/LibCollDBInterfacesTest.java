package libcoll.libcollections;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class LibCollDBInterfacesTest {
    private  LibCollDBInterfaces itfc;

    public LibCollDBInterfacesTest() {
        itfc = new LibCollDBInterfaces();
    }

    @Test
    public void testCategories() {
        assertFalse(itfc.categoryExists("NOT"));
        assertFalse(itfc.categoryExists("Category1"));
        assertTrue(itfc.addCategory("Category1"));
        assertTrue(itfc.categoryExists("Category1"));
        assertFalse(itfc.addCategory("Category1"));
        assertTrue(itfc.addCategory("Category2"));
    }

    @Test
    public void testBooks() {
        assertFalse(itfc.bookExists("NOT"));
        assertFalse(itfc.bookExists("false-isbn"));
        assertTrue(itfc.addBook("false-isbn"));
        assertFalse(itfc.addBook("false-isbn"));
        assertTrue(itfc.bookExists("false-isbn"));
        assertFalse(itfc.addBook("false-isbn"));
        assertTrue(itfc.addBook("978-7-121-26054"));
    }

    @Test
    public void testRemark() {
        assertFalse(itfc.remarkBook("NOT", "remark"));
        assertTrue(itfc.remarkBook("false-isbn", "remark"));
    }
}
