package laboration5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.xml.parsers.ParserConfigurationException;

class TreeFrame extends JFrame implements ActionListener {
    JCheckBox box;
    JTree tree;
    DefaultMutableTreeNode root;
    DefaultTreeModel treeModel;
    JPanel controls;
    static final String closeString = " Close ";
    static final String showString = " Show Details ";

    void getTreeFrame() {
		Container c = getContentPane();
	
		initTree();
	
		tree.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			    if (box.isSelected())
				showDetails(tree.getPathForLocation(e.getX(), 
								    e.getY()));
			}
		    });
		    
		controls = new JPanel();
		box = new JCheckBox(showString);
		initGUI();
		c.add(controls, BorderLayout.NORTH);
		c.add(tree, BorderLayout.CENTER);   
		setVisible(true);
    } 

    public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals(closeString))
		    dispose();
    }

    void initGUI() {
		tree.setFont(new Font("Dialog", Font.BOLD, 12));
		controls.add(box);
		addButton(closeString);
		controls.setBackground(Color.lightGray);
		controls.setLayout(new FlowLayout());    
		setSize(400, 400);
    }
 
    void addButton(String n) {
		JButton b = new JButton(n);
		b.setFont(new Font("Dialog", Font.BOLD, 12));
		b.addActionListener(this);
		controls.add(b);
    }

    // ***** Override initTree in subclass
    // ***** create root, treeModel and tree in the new initTree
    void initTree() {
		root = new DefaultMutableTreeNode("11");
		treeModel = new DefaultTreeModel(root);
		tree = new JTree(treeModel);
		
    }

    // ***** showDetails can also be overridden in a subclass *****
    void showDetails(TreePath path){
		if (path == null)
		    return;
		String info = path.getLastPathComponent().toString();
		JOptionPane.showMessageDialog(this, info);
    }

    public static void main(String[] u) {
    	new TreeFrame();
    }
}