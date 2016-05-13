package gui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import controller.Controller;
import exception.NotPermittedCommandException;
import interfaces.Command;
import interfaces.IView;
import interfaces.IWorkspace;
import model.Workspace;
import utils.SysKB;

/**
 * Questa classe contiene il main del sistema.
 * 
 * @author ashleycaselli
 *
 */
public class Application {

    public static void main(String[] args) {
	IView view = new MainUI();
	Controller controller = new Controller();
	IWorkspace model = new Workspace();
	controller.setModel(model);
	controller.setView(view);
	view.registerObserver(controller);

	InputStream s = Application.class.getResourceAsStream("/resources/archive");
	try {
	    System.out.println("Copying File into: " + SysKB.FILE_PATH
		    + "\n............................................................................");
	    FileOutputStream fileOut = new FileOutputStream(new File(SysKB.FILE_PATH));
	    int read = 0;
	    byte[] bytes = new byte[1024];

	    while ((read = s.read(bytes)) != -1) {
		fileOut.write(bytes, 0, read);
	    }
	    System.out.println("Done!\n");
	    s.close();
	    fileOut.close();
	} catch (IOException e1) {
	    e1.printStackTrace();
	}

	try {
	    controller.execCommand(Command.LOAD);
	} catch (NotPermittedCommandException e) {
	    e.printStackTrace();
	}
    }

}
