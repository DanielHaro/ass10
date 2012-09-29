import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;


public class TextListner extends JPanel implements NewTextListner{

	/**
	 * Create the panel.
	 */
	
	private JTextArea jpaListner;// = new JTextArea();
	private TextSource textSource;
	private boolean buffState = false;	
	
	public void setTextSource(TextSource textSource) {
		this.textSource = textSource;
		textSource.addNewTextListner(this);
		
		
	}


	public TextListner() 
		{
		setBackground(Color.YELLOW);
		setForeground(Color.YELLOW);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JScrollPane jscrListner = new JScrollPane();
		jscrListner.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jscrListner.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(jscrListner);
		
		jpaListner = new JTextArea();
		jpaListner.setBackground(Color.LIGHT_GRAY);
		jpaListner.setColumns(30);
		jpaListner.setRows(14);
		jscrListner.setViewportView(jpaListner);
 
		
		
	}
	
	
	public void newTextEntered(NewTextEvent ev)
	{
	
		String nt = ev.getNewText();
		
		
		if(nt.equals("begin"))
			buffState = true;
		
		if(nt.equals("cancel"))
			buffState = false;
		
		System.out.println(nt);
		jpaListner.append(nt + "\n");
		//update the buffer
		if(buffState)
		textSource.updateBuffer(nt);
		
		
		
	}

}
