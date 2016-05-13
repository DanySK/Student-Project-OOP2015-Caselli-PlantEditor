package interfaces;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.PlantSourceFile;

public class PlantSourceFileTest {

    private FileType fileType = null;
    private IPlantSourceFile plantFile = null;

    @Before
    public void setUp() throws Exception {
	fileType = FileType.PLANTUML;
	plantFile = new PlantSourceFile("Prova");
    }

    @After
    public void tearDown() throws Exception {
	fileType = null;
	plantFile = null;
    }

    @Test
    public void testGetFileType() {
	assertTrue(plantFile.getFileType().equals(fileType));
    }

    @Test
    public void testGetAndSetContent() {
	String tmp = "questo è il contenuto di default per il test";
	plantFile.setContent(tmp);
	assertTrue(plantFile.getContent().equals(tmp));
    }

}
