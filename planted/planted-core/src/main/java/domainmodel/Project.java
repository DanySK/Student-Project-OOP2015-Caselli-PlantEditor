package domainmodel;

import java.util.ArrayList;
import java.util.List;

import interfaces.IProject;
import interfaces.ISourceEntityImpl;

@SuppressWarnings("serial")
public class Project implements IProject {

    private List<ISourceEntityImpl> srcFiles;
    private String name;

    public Project(String name) {
	this.name = name.trim();
	this.srcFiles = new ArrayList<>();
    }

    @Override
    public void setName(String name) {
	this.name = name.trim();
    }

    @Override
    public String getName() {
	return this.name;
    }

    @Override
    public int hashCode() {
	return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
	IProject ptmp = (IProject) obj;
	return ptmp.getName().equals(this.name);
    }

    @Override
    public String toString() {
	return "Project [name=" + this.name + "]";
    }

    @Override
    public boolean addFile(ISourceEntityImpl srcFile) {
	if (this.srcFiles.contains(srcFile)) {
	    return false;
	} else {
	    this.srcFiles.add(srcFile);
	    return true;
	}
    }

    @Override
    public boolean removeFile(ISourceEntityImpl srcFile) {
	return this.srcFiles.remove(srcFile);
    }

    @Override
    public List<ISourceEntityImpl> getSrcFiles() {
	return this.srcFiles;
    }

}
