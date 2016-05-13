package model;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

import interfaces.IProject;
import interfaces.ISourceEntityImpl;
import interfaces.IWorkspace;
import utils.DirUtils;
import utils.SysKB;

/**
 * Questa classe rappresenta un workspace. Implementa l'interfaccia
 * <code>IWorkspace</code> ed estende la classe <code>HashMap</code>.
 * 
 * @author ashleycaselli
 *
 */
@SuppressWarnings("serial")
public class Workspace extends HashMap<Integer, IProject> implements IWorkspace {

    public Workspace() {
	super();
	DirUtils.createWorkspace();
    }

    @Override
    public void clearData() {
	this.clear();
    }

    @Override
    public void setName(String name) {
	try {
	    throw new UnsupportedOperationException();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    @Override
    public String getName() {
	return SysKB.WORKSPACE_NAME;
    }

    @Override
    public void save(OutputStream out) throws IOException {
	new ObjectOutputStream(out).writeObject(this);
    }

    @Override
    public void load(InputStream in) throws ClassNotFoundException, IOException {
	@SuppressWarnings("unchecked")
	HashMap<Integer, IProject> r = (HashMap<Integer, IProject>) new ObjectInputStream(in).readObject();
	this.clearData();
	this.putAll(r);
    }

    @Override
    public boolean addData(IProject project) {
	if (!this.containsKey(project.hashCode())) {
	    this.put(project.hashCode(), project);
	    return true;
	} else {
	    return false;
	}
    }

    @Override
    public boolean addData(ISourceEntityImpl srcFile, IProject project) {
	if (!this.containsKey(project.hashCode())) {
	    return false;
	} else {
	    return this.get(project.hashCode()).addFile(srcFile);
	}
    }

    @Override
    public boolean removeData(IProject project) {
	return this.remove(project.hashCode()) != null;
    }

    @Override
    public boolean removeData(ISourceEntityImpl srcFile, IProject project) {
	if (!this.containsKey(project.hashCode())) {
	    return false;
	} else {
	    return this.get(project.hashCode()).removeFile(srcFile);
	}
    }

}
