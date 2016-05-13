package interfaces;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.JavaSourceFile;
import model.Project;

public class ProjectTest {

    private IProject proj = null;
    private ISourceFile testFile = null;

    @Before
    public void setUp() throws Exception {
	proj = new Project("proj-prova");
	testFile = new JavaSourceFile("Prova");
    }

    @After
    public void tearDown() throws Exception {
	proj = null;
	testFile = null;
    }

    @Test
    public void testAddFile() {
	assertTrue(proj.addFile(testFile));
    }

    @Test
    public void testRemoveFile() {
	proj.addFile(testFile);
	assertTrue(proj.removeFile(testFile));
    }

    @Test
    public void testGetSrcFiles() {
	List<ISourceFile> srcFiles = new ArrayList<>();
	srcFiles.add(testFile);
	proj.addFile(testFile);
	assertTrue(srcFiles.equals(proj.getSrcFiles()));
    }

}
