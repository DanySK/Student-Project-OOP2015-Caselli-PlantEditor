package interfaces;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.JavaSourceFile;
import model.Project;
import model.Workspace;
import utils.SysKB;

public class ModelTest {

    private IModel model = null;
    private IProject project = null;
    private ISourceEntityImpl source = null;

    @Before
    public void setUp() throws Exception {
	model = new Workspace();
	project = new Project("proj-test");
	source = new JavaSourceFile("prova");
    }

    @After
    public void tearDown() throws Exception {
	model = null;
	project = null;
	source = null;
    }

    @Test
    public void testSave() {
	File f = new File(SysKB.FILE_PATH);
	model.addData(project);
	model.addData(source, project);
	try {
	    model.save(new FileOutputStream(f));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	assertTrue(f.exists());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testLoad() {
	File f = new File(SysKB.FILE_PATH);
	try {
	    model.load(new FileInputStream(f));
	} catch (ClassNotFoundException | IOException e) {
	    e.printStackTrace();
	}
	assertTrue(((HashMap<Integer, IProject>) model).size() != 0);

    }

    @SuppressWarnings("unchecked")
    @Test
    public void testClearData() {
	model.addData(project);
	model.clearData();
	assertTrue(((HashMap<Integer, IProject>) model).size() == 0);
    }

    @Test
    public void testAddDataIProject() {
	assertTrue(model.addData(project));
    }

    @Test
    public void testAddDataISourceEntityImplIProject() {
	model.addData(project);
	assertTrue(model.addData(source, project));
    }

    @Test
    public void testRemoveDataIProject() {
	model.addData(project);
	assertTrue(model.removeData(project));
    }

    @Test
    public void testRemoveDataISourceEntityImplIProject() {
	model.addData(project);
	model.addData(source, project);
	assertTrue(model.removeData(source, project));
    }

}
