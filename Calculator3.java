import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Calculator3 
{
	JFrame fr=new JFrame("Calculator");
	JTextField tb=new JTextField("0");
	JPanel pa=new JPanel();
	JButton [] bt=new JButton[20];
	public Calculator3()
	{
		fr.setSize(400,450);
		fr.setLocationRelativeTo(null);
		fr.setResizable(false);
		fr.setDefaultCloseOperation(3);
		fr.setLayout(null);
		addTextBox();
		addButtons();
		fr.setVisible(true);
	}
	private void addTextBox()
	{
		tb.setBounds(20,20,350,43);
		tb.setFont(new Font("arial",Font.PLAIN,25));
		tb.setHorizontalAlignment(JTextField.RIGHT);
		tb.setEditable(false);
		tb.setBackground(Color.white);
		tb.setBorder(BorderFactory.createLineBorder(Color.black,1));
		fr.add(tb);
	}
	private void addButtons()
	{
		pa.setBounds(20,90,350,300);
		fr.add(pa);
		pa.setLayout(new GridLayout(5,4,5,5));
		Font font=new Font("arial",0,20);
		String [] str= {"Back","CE","C","%","7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
		CalculatorListener listener=new CalculatorListener();
		for(int i=0;i<20;i++)
		{
			bt[i]=new JButton(str[i]);
			bt[i].addActionListener(listener);
			if(i==3 || i==7 || i==11|| i==15 || i==18 || i==19)
				bt[i].setForeground(Color.red);
			else
				bt[i].setForeground(Color.blue);
			bt[i].setFont(font);
			pa.add(bt[i]);
		}
		bt[17].setFont(new Font("elephant",0,25));
	}// end of constructor of class Calculator
	class CalculatorListener implements ActionListener
	{
		JButton bb;// It will hold reference of button clicked
		String t1;// It will hold text of clicked button
		String t2;// It will hold text of text box
		int op=0;
		float num1,num2;
		String opb=null;
		public void actionPerformed(ActionEvent evt)
		{
		    bb=(JButton)evt.getSource();
		    // condition of operation  button for arithmatic 
		    if(bb==bt[3] ||bb==bt[7] ||bb==bt[11] ||bb==bt[15] ||bb==bt[19] )
		    {
		    	if(opb!=null)
		    		call();
		    	op=1;
		    	num1=Float.parseFloat(tb.getText());
		        opb=bb.getText();
		    }
		    if(bb==bt[17])/// .button
		    {
		    	t1=tb.getText();
		    	int i=t1.indexOf(".");
		    	if(i!=-1)
		    	{
		    		return;
		    	}
		    }
		    if(bb==bt[4] ||bb==bt[5] ||bb==bt[6] ||bb==bt[8] ||bb==bt[9] ||bb==bt[10] ||bb==bt[12] ||bb==bt[13] ||bb==bt[14 ]|| bb==bt[16] || bb==bt[17] )
		    {
			    t1=bb.getText();//code to get text from the clicked button
			    t2=tb.getText();//code to get text from the text box
			    if(t2.equals("0")|| op==1)
			    {
			         tb.setText(t1);// code to set value of t1 into textbox
			         op=0;
			    }
			    else
			    {
			         tb.setText(t2+t1);// code to set value of concatination of t1 and t2 value into textbox
			    }
		    }
		    if(bb==bt[18])// equal(=) button
		    {
		    	call();
		    	op=1;
		    	opb=null;
		    	num1=num2=0;
		    }
		    if(bb==bt[2])// c button
		    {
		    	op=0;
		    	opb=null;
		    	tb.setText("0");
		    	num1=num2=0;
		    }
		    if(bb==bt[0])//  back space button
		    {
		    	t1=tb.getText();
		    	if(t1.length()==1)
		    	{
		    		tb.setText("0");
		    		return;
		    	}
		    	if(!t1.equals("0"))
		    	{
		          	t1=t1.substring(0,t1. length()-1);
		          	tb.setText(t1);
		    	}
		    }

		}
		private void call()
		{
			num2=Float.parseFloat(tb.getText());
	    	if(opb.equals("+"))//+button
	    	{
	         	float res=num1+num2;
	         	setResult(res);
	    	    opb=bb.getText();
	    	}  
	    	else if(opb.equals("-"))//-button
	    	{
	         	float res=num1-num2;
	         	setResult(res);
	    	}
	    	else if(opb.equals("*"))//*button
	    	{
	         	float res=num1*num2;
	         	setResult(res);
	    	}
	    	else if(opb.equals("/"))// /button
	    	{
	         	float res=num1/num2;
	    	    setResult(res);
	    	}
	    	else if(opb.equals("%"))// %button
	    	{
	         	float res=num1%num2;
	    	    setResult(res);
	    	}


		}
		private void setResult(float res)
		{
			int x=(int)res;
			if((float)x==res)
			    tb.setText(String.valueOf(x));
			else
				tb.setText(String.valueOf(res));
		}
	}
	public static void main(String[] args) 
	{
		new Calculator3();
	}
}//end of class Calculator
