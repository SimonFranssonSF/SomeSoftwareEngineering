package laboration5;

import javax.swing.tree.DefaultMutableTreeNode;

public class MyNode extends DefaultMutableTreeNode{
	String level;
	String text;
	
	MyNode(String name, String level, String text){
		super(name);
		this.level = level;
		this.text = text;
	}
	
	public String getLevelText(){
		return this.level;
	}
	public String getText(){
		return this.text;
	}
}
