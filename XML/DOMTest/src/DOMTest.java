import java.io.File;
import java.io.IOException;

import javax.xml.crypto.dsig.Transform;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest {
	
	public DocumentBuilder getDocumentBuilder() {
		// 创建一个DocumentBuilderFactory的对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//创建DocumentBuilder对象
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return db;
	}

	/**
	 * 解析xml文件
	 */
	public void xmlParser() {
		try {
			//通过DocumentBuilder对象的parse方法加载book.xml文件到当前项目下
			Document document = getDocumentBuilder().parse("books.xml");
			//获取所有book节点的集合
			NodeList bookList = document.getElementsByTagName("book");
			//通过nodelist的getLength（）方法可以获取bookList的长度
			System.out.println("一共有" + bookList.getLength() + "本书");
			//遍历每一个book节点
			for (int i = 0; i < bookList.getLength(); i++) {
				System.out.println("============下面开始遍历第" + (i+1) + "本书的内容============");
				//通过item(i)方法获取一个book节点，nodeList的索引值从0开始
				Node book = bookList.item(i);
				//获取book节点的所有属性集合
				NamedNodeMap attrs = book.getAttributes();
				System.out.println("第" + (i+1) + "本书共有" + attrs.getLength() + "个属性");
				//遍历book的属性
				for (int j = 0; j < attrs.getLength(); j++) {
					//通过item(index)方法获取book节点的某一个属性
					Node attr = attrs.item(j);
					//获取属性名
					System.out.print("属性名：" + attr.getNodeName());
					//获取属性值
					System.out.println("--属性值：" + attr.getNodeValue());
				}
				
				//前提：已经知道book节点有且只有1个id属性
				//将book节点进行强制类型转换，转换成Element类型
//				Element book = (Element) bookList.item(i);
//				/通过getAttribute("id")方法获取属性值
//				String attrValue = book.getAttribute("id");
//				System.out.println("id属性的属性值为" + attrsValue);
				
				//解析book节点的子节点
				NodeList childNodes = book.getChildNodes();
				//遍历childNodes获取每个节点的节点名和节点值
				System.out.println("第" + (i+1) + "本书共有" + childNodes.getLength() + "个子节点");
				for (int k = 0; k < childNodes.getLength(); k++) {
					//区分出text类型的node以及element类型的node
					if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
						//获取了element类型节点的节点名
						System.out.print("第" + (k+1) + "个节点的节点名：" + childNodes.item(k).getNodeName());
						//获取了element类型节点的节点值
						//System.out.println("--节点值是：" + childNodes.item(k).getFirstChild().getNodeValue());
						System.out.println("--节点值是：" + childNodes.item(k).getTextContent());
					}
				}
				
				
				System.out.println("============结束遍历第" + (i+1) + "本书的内容============");
			}
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * 生成xml
	 */
	public void createXML() {
		DocumentBuilder db = getDocumentBuilder();
		Document document = db.newDocument();
		document.setXmlStandalone(true);
		
		Element bookstore = document.createElement("bookstore");
		//向bookstore根节点中添加子节点book
		Element book = document.createElement("book");
		Element name = document.createElement("name");
		name.setTextContent("小王子");
		book.appendChild(name);
		
		book.setAttribute("id", "1");
		//将book节点添加到bookstore根节点中
		bookstore.appendChild(book);
		//将bookstore节点（已经包含了book）添加到dom树中
		document.appendChild(bookstore);
		
		//创建TransformerFactory对象
		TransformerFactory tff = TransformerFactory.newInstance();
		try {
			//创建Transformer对象
			Transformer tf = tff.newTransformer();
			
			//设置换行和缩进
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			//tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			
			tf.transform(new DOMSource(document), new StreamResult(new File("books1.xml")));
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 主方法：程序的入口
	 * @param args
	 */
	public static void main(String[] args) {
		//创建DOMTest对象
		DOMTest test = new DOMTest();
		//调用解析方法，解析xml文件
//		test.xmlParser();
		test.createXML();
	}

}
