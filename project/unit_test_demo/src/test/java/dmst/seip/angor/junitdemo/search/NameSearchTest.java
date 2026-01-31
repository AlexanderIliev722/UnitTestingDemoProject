package dmst.seip.angor.junitdemo.search;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

import dmst.seip.angor.junitdemo.io.FileIO;

public class NameSearchTest {
	
	
	@Test
	public void testFindNamesInFileThatStartWith() {
		FileIO fileio = mock(FileIO.class);
		
		String path = "src/test/resources/names_valid.txt";
		when(fileio.readFile(path)).thenReturn(new String[] {"Mitch","Chris","John","Carol"});
		
		NameSearch ns = new NameSearch();
		String[] expected = {"Chris","Carol"};
		String[] actual = ns.findNamesInFileThatStartWith(path, fileio, "C");
		
		assertArrayEquals(expected, actual);
	}
//Zadacha 15 b)
	@Test
	public void testFindNames_PrefixNotFound() {
		NameSearch ns = new NameSearch();
		FileIO mockIO = mock(FileIO.class);

		String[] mockNames = {"Alice", "Bob", "Charlie"};
		when(mockIO.readFile(anyString())).thenReturn(mockNames);

		String[] result = ns.findNamesInFileThatStartWith("dummy_path", mockIO, "Ma");

		Assert.assertNotNull("Result should not be null", result);
		Assert.assertEquals("Should find 0 matches", 0, result.length);
	}
	
}
