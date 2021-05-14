
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.lang.Math;


public class Project implements ActionListener
{
    JButton button, enter;
    JFrame frame;
    JTextField input;
    JLabel label;
    Panel panel;
    JTextArea closest, buy_above, sell_below, btarg1, btarg2, btarg3, btarg4, btarg5;
    JTextArea starg1, starg2, starg3, starg4, starg5;
    JTextArea space1, space2, space3, space4, space5, space6, huge_space;
	JLabel initials;
    public static float data[] = new float[40366];

    public Project() {
	frame = new JFrame("Project");
	panel = new Panel();
	panel.setBounds(0, 0, 600, 200);
	Color colour = new Color(224, 224, 224);
	panel.setBackground(colour);

	Font font = new Font("Verdana", Font.BOLD, 12);

	closest = new JTextArea(5, 60);
	closest.setLineWrap(true);
	closest.setBackground(colour);

	label = new JLabel ("VWAP Price at 9.35: ");
	label.setForeground(Color.red);

	input = new JTextField(6);

	enter = new JButton ("Enter");
	enter.addActionListener (this);
	enter.setForeground (Color.black);
	enter.setBackground (Color.green);
	enter.setBounds(100, 100, 80, 30);


	buy_above = new JTextArea(1, 20);
	buy_above.setLineWrap(true);
	buy_above.setForeground(Color.BLUE);
	buy_above.setFont(font);
	
	//spaces
	space1 = new JTextArea(1, 10);
	space1.setLineWrap(true);
	space1.setBackground(colour);
	space1.setForeground(colour);

	space2 = new JTextArea(1, 10);
	space2.setLineWrap(true);
	space2.setBackground(colour);
	space2.setForeground(colour);

	space3 = new JTextArea(1, 10);
	space3.setLineWrap(true);
	space3.setBackground(colour);
	space3.setForeground(colour);

	space4 = new JTextArea(1, 10);
	space4.setLineWrap(true);
	space4.setBackground(colour);
	space4.setForeground(colour);

	space5 = new JTextArea(1, 10);
	space5.setLineWrap(true);
	space5.setBackground(colour);
	space5.setForeground(colour);

	space6 = new JTextArea(1, 10);
	space6.setLineWrap(true);
	space6.setBackground(colour);
	space6.setForeground(colour);

	sell_below = new JTextArea(1, 20);
	sell_below.setLineWrap(true);
	sell_below.setForeground(Color.RED);
	sell_below.setFont(font);

	//btargs
	btarg1 = new JTextArea(1, 20);
	btarg1.setLineWrap(true);
	btarg1.setFont(font);
      
	btarg2 = new JTextArea(1, 20);
	btarg2.setLineWrap(true);
	btarg2.setFont(font);
      
	btarg3 = new JTextArea(1, 20);
	btarg3.setLineWrap(true);
	btarg3.setFont(font);
  
	btarg4 = new JTextArea(1, 20);
	btarg4.setLineWrap(true);
	btarg4.setFont(font);

	btarg5 = new JTextArea(1, 20);
	btarg5.setLineWrap(true);
	btarg5.setFont(font);
  
	/*space = new JTextArea(5, 60);
	space.setLineWrap(true);
	space.setBackground(colour);*/
     
	//stargs
	starg1 = new JTextArea(1, 20);
	starg1.setLineWrap(true);
	starg1.setFont(font);

	starg2 = new JTextArea(1, 20);
	starg2.setLineWrap(true);
	starg2.setFont(font);
     
	starg3 = new JTextArea(1, 20);
	starg3.setLineWrap(true);
	starg3.setFont(font);
     
	starg4 = new JTextArea(1, 20);
	starg4.setLineWrap(true);
	starg4.setFont(font);
   
	starg5 = new JTextArea(1, 20);
	starg5.setLineWrap(true);
	starg5.setFont(font);

	huge_space = new JTextArea(10, 60);
	huge_space.setLineWrap(true);
	huge_space.setBackground(colour);

	initials = new JLabel("By: Pari Shah");
	initials.setForeground(Color.black);
	initials.setFont(font);
	initials.setBackground(colour);
	

	panel.add(label);
	panel.add(input);
	panel.add(enter);
	panel.add(closest);
	panel.add(buy_above);

	//new order
	panel.add(space1);
	panel.add(sell_below);
	panel.add(btarg1);
	panel.add(space2);
	panel.add(starg1);
	panel.add(btarg2);
	panel.add(space3);
	panel.add(starg2);
	panel.add(btarg3);
	panel.add(space4);
	panel.add(starg3);
	panel.add(btarg4);
	panel.add(space5);
	panel.add(starg4);
	panel.add(btarg5);
	panel.add(space6);
	panel.add(starg5);
	panel.add(huge_space);
	panel.add(initials, BorderLayout.PAGE_END);
 
	frame.setLayout(new BorderLayout());
	frame.add(panel);
	frame.setSize(770, 500);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
	
	float num = Float.parseFloat(input.getText());
	//now find the closest value. 
	float closest_value = data[0];
	float subtract_result = Math.abs(closest_value - num);
	int size = data.length;
	int count = 0;
	boolean same = false;
	for (int i = 1; i < size; i++) {
	    if (Math.abs(data[i] - num) < subtract_result) {
		subtract_result = Math.abs(data[i] - num);
		if (data[i] < num) {
		    closest_value = data[i+1];
		    count = i+1;
		}
		else {
			if (data[i] == num) { //number is found in the data
				same = true;
			}
		    closest_value = data[i];
		    count = i;
		}
		
	    }
	}

	float above[] = new float[6];
	float below[] = new float[6];
	int apos = 0;
	for (int i = count+1; i < count+7; i++) {
	    if (i < 0 || i >= size) {
		above[apos] = 0;
		apos++;
	    }
	    else {
		above[apos] = data[i];
		apos++;
	    }
	}
	
	int bpos = 0;
	for (int i = count-1; i > count-7; i--) {
	    if (i < 0 || i >= size) {
		below[bpos] = 0;
		bpos++;
	    }
	    else {
		below[bpos] = data[i];
		bpos++;
	    }
	}

	//closest.setText("Closest value found: " + closest_value);
	if (same == true) {
		buy_above.setText("Buy Above: " + String.format("%.2f", above[0]));
		btarg1.setText("Target 1: " + String.format("%.2f", above[1]));
		btarg2.setText("Target 2: " + String.format("%.2f", above[2]));
		btarg3.setText("Target 3: " + String.format("%.2f", above[3]));
		btarg4.setText("Target 4: " + String.format("%.2f", above[4]));
		btarg5.setText("Target 5: " + String.format("%.2f", above[5]));
		sell_below.setText("Sell Below: " + String.format("%.2f", below[0]));
		starg1.setText("Target 1: " + String.format("%.2f", below[1]));
		starg2.setText("Target 2: " + String.format("%.2f", below[2]));
		starg3.setText("Target 3: " + String.format("%.2f", below[3]));
		starg4.setText("Target 4: " + String.format("%.2f", below[4]));
		starg5.setText("Target 5: " + String.format("%.2f", below[5]));
	}
	else {
		buy_above.setText("Buy Above: " + String.format("%.2f", closest_value));
		btarg1.setText("Target 1: " + String.format("%.2f", above[0]));
		btarg2.setText("Target 2: " + String.format("%.2f", above[1]));
		btarg3.setText("Target 3: " + String.format("%.2f", above[2]));
		btarg4.setText("Target 4: " + String.format("%.2f", above[3]));
		btarg5.setText("Target 5: " + String.format("%.2f", above[4]));
		sell_below.setText("Sell Below: " + String.format("%.2f", below[0]));
		starg1.setText("Target 1: " + String.format("%.2f", below[1]));
		starg2.setText("Target 2: " + String.format("%.2f", below[2]));
		starg3.setText("Target 3: " + String.format("%.2f", below[3]));
		starg4.setText("Target 4: " + String.format("%.2f", below[4]));
		starg5.setText("Target 5: " + String.format("%.2f", below[5]));
	}
	


	

	
    }


    public static void main (String args[]) throws Exception
    {
	Scanner scanner = new Scanner(new File("data.txt"));
	int idx = 0;
	while(scanner.hasNextFloat()) {
	    data[idx++] = scanner.nextFloat(); //add data. 
	}

	//sort array.
	Arrays.sort(data);

	Project test = new Project();
    }



}
