package non_LinearDataStructures;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeVisualiser extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Draw root
		g.drawOval(190, 20, 40, 40);
		g.drawString("Root", 195, 45);

		// Draw children
		g.drawLine(210, 60, 120, 120);
		g.drawLine(210, 60, 300, 120);

		// Left child A
		g.drawOval(100, 120, 40, 40);
		g.drawString("A", 115, 145);
		// Draw child
		g.drawLine(140, 200, 120, 120);

		// Left child AA
		g.drawOval(140 + 120, 120 + 160, 40, 40);
		g.drawString("AA", 115, 145);

		// Right child B
		g.drawOval(280, 120, 40, 40);
		g.drawString("B", 295, 145);
	}

	public static void main(String[] args) {
		// Root node
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("University");

		// Faculties
		DefaultMutableTreeNode science = new DefaultMutableTreeNode("Science");
		DefaultMutableTreeNode arts = new DefaultMutableTreeNode("Arts");

		// Departments under Science
		science.add(new DefaultMutableTreeNode("Mathematics"));
		science.add(new DefaultMutableTreeNode("Physics"));

		// Departments under Arts
		arts.add(new DefaultMutableTreeNode("History"));
		arts.add(new DefaultMutableTreeNode("Philosophy"));

		// Add faculties to root
		root.add(science);
		root.add(arts);

		// Create tree
		JTree tree = new JTree(root);

		// Add listener to detect selection
		tree.addTreeSelectionListener(e -> {
			DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
			if (selectedNode != null) {
				String selectedValue = selectedNode.toString();
				JOptionPane.showMessageDialog(null, "You selected: " + selectedValue);
			}
		});

		// Display in frame
		JFrame frame = new JFrame("Interactive JTree Example");
		frame.add(new JScrollPane(tree));
		frame.add(new TreeVisualiser());
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
