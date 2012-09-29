import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
//listner of ActionEvent
//Source of NewTextEvent
//must implemnt intercae
//must registar


public class TextSource extends JPanel implements ActionListener{
	private JTextField jtfSourceText;
	private NewTextListner newTextListner;
	private String Buffer;

	/**
	 * Create the panel.:constructor!
	 */
	public TextSource()
	
	{
		setBackground(Color.YELLOW);
		
		JLabel jlbSourceText = new JLabel("Soucrse text");
		add(jlbSourceText);
		
		jtfSourceText = new JTextField();
		add(jtfSourceText);
		jtfSourceText.setColumns(10);
		//registar
		jtfSourceText.addActionListener(this);
		Buffer ="";

	}

	public void updateBuffer(String buff)
	{
		Buffer = Buffer + buff;
		
	}
	//make a soucres of new text
			public void addNewTextListner(NewTextListner nt1)
			
			{newTextListner = nt1; }
			
			
			public void removeNewTextListener(NewTextListner nt1)
			{
				newTextListner = null;
				
			}
			
	public void fireNewTextEntered (String nt)
	{
		
		NewTextEvent ev = new NewTextEvent(nt);
		if (newTextListner != null)
		newTextListner.newTextEntered(ev);
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String nt = jtfSourceText.getText().trim();
		jtfSourceText.setText("");
		fireNewTextEntered (nt);
	}
	
}
