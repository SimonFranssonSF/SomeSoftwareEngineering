package laboration5;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class RecursiveTreeP extends TreeFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JFileChooser chooser; //om inga args sa kan man valja fil, default ar liv.xml
    private File xmlFile; //filen som lases in via args, default eller JChooser, kan vara bade .txt och .xml
    private Document doc = null; //Dom dokument som ska representera xml-filen
	private Scanner scanner; //Scanner för att validera alla rader i xml-filen
	
    /*Laser in en xml fil fran JChooser och kollar om den är valid,om ingen fil ar vald sa kors liv.xml som default
	  om den är det så körs getTreeFrame vilken kor metoden initTree som bygger tradet*/
	private RecursiveTreeP() throws FileNotFoundException{
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.chooser = new JFileChooser(".");
		FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files (*.xml)", "xml", "txt");
		chooser.setFileFilter(xmlfilter);
        chooser.setDialogTitle("Open a txt or XML file");
		int result = chooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File theFile = chooser.getSelectedFile();
		    this.xmlFile = theFile;
		}else{
			this.xmlFile = new File("src/resources/Life.xml");
		}
		if(validate(xmlFile)){
			this.getTreeFrame();
		}else{
			System.out.println("The xml is not valid.");
		}
	}
	
	 /*Laser in en xml fil fran args och kollar om den är valid,
	  om den är det så körs getTreeFrame vilken kor metoden initTree som bygger tradet*/
	private RecursiveTreeP(String filePath) throws FileNotFoundException{
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		System.out.println("aa");
		this.xmlFile = new File(filePath);
		//kollar så att alla hakparanteser är korrekta, om så är fallet så bygger vi trädet annars inte.
		if(validate(xmlFile)){
			this.getTreeFrame();
		}else{
			System.out.println("The xml is not valid.");
		}
	}
	
	//parsar xml filen och satter root, treemodel och tree. Anrovar "buildTree" som bygger tradet.
	@Override
	void initTree(){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); //Tillgang till parser som omvandlar till Dom dokument
		DocumentBuilder db = null; //documentbuilder
		
		try {
			//Ny instans av documentBuilder
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		try {
			//Parsa som .xml returnera DOM dokument
			doc = db.parse(xmlFile);
		} catch (SAXException | IOException e) {
			System.out.println("Not valid xml-data");
			System.exit(0);
			//e.printStackTrace();
		}
		//puts all treeNodes in the full depth of the sub-tree undearneath the root node
		//Slår samman angränsande textnoder och tar bort tomma textnoder i hela dokumentet
		doc.getDocumentElement().normalize();
		
		//Skapa roten, MyNode(RootName, rootLevel, rootText)
		String rootLevel = doc.getDocumentElement().getTagName();
		String rootName = doc.getDocumentElement().getAttribute("namn");
		String rootText = doc.getDocumentElement().getFirstChild().getTextContent();
		root = new MyNode(rootName, rootLevel, rootText);
		treeModel = new DefaultTreeModel(root);
		tree = new JTree(treeModel);
		tree.setBackground(Color.GREEN);
		buildTree();
	}

	//H�mtar rotens direkta barn och g�r ett anrop till buildTree(child, parent) for varje barn.
	private void buildTree() {
		Element rootElement = doc.getDocumentElement();
		NodeList children = rootElement.getChildNodes();
		Node current = null;
			for (int i = 0; i < children.getLength(); i++) {
				current = children.item(i);
				if (current.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) current;
					buildTree(element, root); 
				}
			}
	}
	
	private void buildTree(Element e, DefaultMutableTreeNode parent){
		String level = e.getTagName();
		String text = e.getFirstChild().getTextContent();
		DefaultMutableTreeNode child = new MyNode(e.getAttribute("namn"), level, text);
		parent.add(child);
		//om detta barn har egna barn sa anropas buildTree igen med detta barn som parent. Och barnen till denna som barn.
		//Valdigt likt laboration 4, "composite" och "Leaves"
		if (e.hasChildNodes()) {
			NodeList children = e.getChildNodes();
			Node current = null;
			for (int i = 0; i < children.getLength(); i++) {
				current = children.item(i);
				if (current.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) current;
					buildTree(element, child); 
				}
			}           
		} 
	}
	
	 // Overrides method in TreeFrame
	//Bygger infostrang som ska presenteras i en dialogruta mha parametrarna i MyNode
	//Hamtar kedjan till roten och presenterar den ocksa
	 void showDetails(TreePath path){
		if (path == null)
		    return;
		MyNode n = (MyNode)path.getLastPathComponent();
		String info = n.getLevelText() + ": " + n.getText() + "\n"; 
		TreeNode[] parents = n.getPath();
		for(int i = parents.length-1; i >= 0; i--){
			TreeNode parent = parents[i];
			if(i != 0){
				info += parent + " ar ";
			}else{
				info += parent;
			}
				
		}
		JOptionPane.showMessageDialog(this, info);
    }

	//In: Fil
	//Ut: boolean
	//returnerar true om en fil innehåller jämt (och i rätt ordning) antal hakparanteser för varje rad.
	private boolean validate(File xml) throws FileNotFoundException {
		Stack<Character> stack = new Stack<Character>();
		scanner = new Scanner(xmlFile);
		while (scanner.hasNext()) {
			String xmlLine = scanner.nextLine();
			for(char character : xmlLine.toCharArray()){
		        switch(character) {
		        	case '<':
		        		stack.push(character);
				        break;
		            case '>':
		                if(stack.isEmpty() || stack.pop() != '<'){
		                    return false;
		                }
		                break;
		        }
		     }
			if(!stack.isEmpty()){
				
				return false;
			}
		}
		scanner.close();
		return true;
	}
	
	//Anropa 2 olika konstruktorer beroende pa om args ar angiven eller inte
	public static void main(String[] args){
		if(args.length == 0){
			try {
				new RecursiveTreeP();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			// src/resources/file.xml
			try {
				new RecursiveTreeP("src/resources/" + args[0]);
				//tree.getTreeFrame();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
}
