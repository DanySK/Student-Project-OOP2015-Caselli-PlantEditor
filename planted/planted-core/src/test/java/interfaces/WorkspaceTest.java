package interfaces;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Workspace;
import utils.SysKB;

public class WorkspaceTest {

    private IWorkspace ws = null;

    @Before
    public void setUp() throws Exception {
	ws = new Workspace();
    }

    @After
    public void tearDown() throws Exception {
	ws = null;
    }

    @Test
    public void testGetName() {
	assertTrue(ws.getName().equals(SysKB.WORKSPACE_NAME));
    }

}
