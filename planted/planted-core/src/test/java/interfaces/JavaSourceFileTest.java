package interfaces;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.JavaSourceFile;

public class JavaSourceFileTest {

    private FileType fileType = null;
    private IJavaSourceFile javaFile = null;

    @Before
    public void setUp() throws Exception {
	fileType = FileType.JAVA;
	javaFile = new JavaSourceFile("Prova");
    }

    @After
    public void tearDown() throws Exception {
	fileType = null;
	javaFile = null;
    }

    @Test
    public void testGetFileType() {
	assertTrue(javaFile.getFileType().equals(fileType));
    }

    @Test
    public void testGetAndSetContent() {
	String tmp = "questo è il contenuto di default per il test";
	javaFile.setContent(tmp);
	assertTrue(javaFile.getContent().equals(tmp));
    }

}
