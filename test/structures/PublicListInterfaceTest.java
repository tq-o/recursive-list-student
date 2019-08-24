package structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PublicListInterfaceTest {

	private ListInterface<String> list;

	@Before
	public void setup(){
          list = new RecursiveList<String>();
	}

	@Test (timeout = 44245500)
	public void testInsertFirstIsEmptySizeAndGetFirst1() {
//		assertTrue("Newly constructed list should be empty.", list.isEmpty());
//		assertEquals("Newly constructed list should be size 0.", 0, list.size());
//		assertEquals("Insert First should return instance of self", list, list.insertFirst("hello"));
//		assertFalse("List should now have elements.", list.isEmpty());
//		assertEquals("List should now have 1 element.", 1, list.size());
//		assertEquals("First element should .equals \"hello\".", "hello", list.getFirst());
//		list.insertFirst("world");
//		assertEquals(2, list.size());
//		list.insertFirst("foo");
//		assertEquals(3, list.size());
//		assertEquals("First element should .equals \"foo\".", "foo", list.getFirst());
		
		
//		list.insertLast("world");
//		list.insertLast("heey");
//		list.insertFirst("hey");
//		list.insertAt(3, "nope");
//		list.insertAt(3, "nope2");
		
		
//		list.insertAt(0,"heey10");
//		
//		list.insertLast("hee2y");
//
//		list.remove("hee2y");
//		
		//list.inser
		assertTrue(list.isEmpty());
		assertEquals(0,list.size());
		assertEquals(list,list.insertAt(0, "Hello"));
		assertFalse(list.isEmpty());
		assertEquals(1,list.size());
		assertEquals("Hello",list.get(0));
		list.insertAt(1, "world");
		assertEquals("world",list.get(1));
		assertEquals(2, list.size());
		list.insertAt(0, "foo");
		assertEquals(3,list.size());
		assertEquals("foo", list.get(0));
		assertEquals("Hello", list.get(1));
		
		
	}
}
