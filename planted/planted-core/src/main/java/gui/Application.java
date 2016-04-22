package gui;

import controller.Controller;
import domainmodel.Workspace;
import exception.NotPermittedCommandException;
import interfaces.Command;
import interfaces.IView;
import interfaces.IWorkspace;

public class Application {

    public static void main(String[] args) {
	IView view = new MainUI();
	Controller controller = new Controller();
	IWorkspace model = new Workspace();
	controller.setModel(model);
	controller.setView(view);
	view.registerObserver(controller);
	try {
	    controller.execCommand(Command.LOAD);
	} catch (NotPermittedCommandException e) {
	    e.printStackTrace();
	}
    }

}
