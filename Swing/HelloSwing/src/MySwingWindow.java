import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MySwingWindow extends JFrame {
	//此处通过继承JFrame类来使我们自己的MySwingWindow具有窗体的一些属性和方法

	private JLabel myLabel;
	
	private JLabel getJLabel() {
		if (myLabel == null) {
			//实例化myLabel对象
			myLabel = new JLabel();
			
			//使用setBounds()方法设置尺寸
	        //四个参数的分别是x,y,width,height
	        //代表了横向、纵向的位置，以及标签自身的宽和高
			myLabel.setBounds(5, 10, 250, 30);
			
			//使用setText()方法设置要显示的文本
			myLabel.setText("Hello! I am Lin Guodan.");
		}
		return myLabel;
	}
	
	private JTextField myTextField;
	
	private JTextField getJTextField() {

	    if(myTextField == null) {
	    	//实例化myTextField对象
	        myTextField = new JTextField();

	        //设置它的位置和尺寸
	        myTextField.setBounds(5, 45, 200, 30);

	        //设定它要显示的字符串
	        myTextField.setText("Hello, Lin");

	    }
	    return myTextField;
	}
	
	private JButton myButton;
	
	private JButton getJButton() {
		if (myButton == null) {
			//实例化myButton对象
			myButton = new JButton();
			
			//设置它的位置和尺寸
			myButton.setBounds(5, 80, 100, 40);
	        
			//设定它要显示的字符串
	        myButton.setText("Click me!");
	        
	        myButton.addActionListener(new ActionListener() {
	        	//为其添加一个事件监听，从而使这个按钮可以响应用户的点击操作
	            //ActionListener是用于接收操作事件的侦听器接口。
	            //对处理操作事件感兴趣的类可以实现此接口，而使用该类创建的对
	            //可使用组件的 addActionListener 方法向该组件注册。
	            //在发生操作事件时，调用该对象的 actionPerformed 方法。
	        	public void actionPerformed(ActionEvent e) {
	                //该方法会在发生操作时被调用，我们要做的事情就可以写在这里面
	                //比如我们下面要做的事情就是改变之前两个控件里面的文字颜色和背景色

	                myLabel.setForeground(Color.RED);
	                //设置此组件的前景色。

	                myTextField.setBackground(Color.BLUE);
	                //设置此组件的背景色。
	            }
	        });
		}
		return myButton;
		
	}
	
	public MySwingWindow() {
		//在窗体的构造方法中设置窗体的各项属性
		
		//使用super()来引用父类的成分，用this来引用当前对象
		super();
		
		//设置窗体的大小
		this.setSize(400, 300);
		
		//返回此窗体的contentPane对象，设置其布局
		this.getContentPane().setLayout(null);
		
		//设置窗体的标题	
		this.setTitle("My First Swing Window");
        
		this.add(getJLabel(),null);
        this.add(getJTextField(), null);
        this.add(getJButton(),null);
        //在自定义的JFrame构造方法中使用add()方法来添加控件
        //add()方法可以将指定组件添加到此容器的给定位置上
        //第一个参数为待添加的组件，这里的组件来自我们的返回值
        //第二个参数为描述组件的布局限制的对象，我们不加限制，所以填null
	}
	
	public static void main(String[] args) {
		//声明一个窗体对象 window
		MySwingWindow window = new MySwingWindow();

		//设置这个窗体是可见的	
	    window.setVisible(true);
	    
	}

}
