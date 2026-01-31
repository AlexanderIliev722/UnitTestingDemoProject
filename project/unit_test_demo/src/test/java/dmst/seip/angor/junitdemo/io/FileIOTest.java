package dmst.seip.angor.junitdemo.io;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

public class FileIOTest {

	FileIO fileio = new FileIO();
	public static String resourcesPath = "src/test/resources/";

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	@Test
	public void testReadFileValidInput() {
		String[] expectedNames = new String[] {
				"Mitch","Newmie","C.J","Matt","Caroline",
				"Jason","Lani","Summer","Logan"};
		String validInputFilepath = resourcesPath.concat("names_valid.txt");
		
		Assert.assertArrayEquals(expectedNames, fileio.readFile(validInputFilepath));
	}
	//Zadacha 15 b)
	@Test
	public void testReadFile_EmptyFile() throws IOException {
		File emptyFile = tempFolder.newFile("empty_test_file.txt");

		FileIO fileIO = new FileIO();

		String[] result = fileIO.readFile(emptyFile.getAbsolutePath());

		Assert.assertNotNull("Result should not be null", result);
		Assert.assertEquals("Array should be empty", 0, result.length);
	}

	//Zadacha 15 b)
	@Test
	public void testReadFile_NonExistentFile() {

		FileIO fileIO = new FileIO();


		String nonExistentPath = "C:/this_directory_does_not_exist/non_existent.txt";

		String[] result = fileIO.readFile(nonExistentPath);


		Assert.assertNotNull("Result should not be null", result);
		Assert.assertEquals("Should return empty array for missing file", 0, result.length);
	}
}
