package top.fxxxx.InformationPortal.Util;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * DOM4j工具类
 * @author caolipeng
 */
public class XmlUtils {
    /**
     * 加入孩子节点元素
     * @param parent 父节点
     * @param childName 孩子节点名称
     * @param childValue 孩子节点值
     * @return 新增节点
     */
    public static Element addChild(Element parent, String childName,
                                   String childValue) {
        Element child = parent.addElement(childName);//加入节点元素
        child.setText(childValue == null ?
                "" : childValue); //为元素设值
        return child;
    }
    /**
     * DOM4j的Document对象转为XML报文串
     * @param document
     * @param charset
     * @return 经过解析后的xml字符串
     */
    public static String documentToString(Document document,String charset) {
        StringWriter stringWriter = new StringWriter();
        OutputFormat format = OutputFormat.createPrettyPrint();//获得格式化输出流
        format.setEncoding(charset);//设置字符集,默觉得UTF-8
        XMLWriter xmlWriter = new XMLWriter(stringWriter, format);//写文件流
        try {
            xmlWriter.write(document);
            xmlWriter.flush();
            xmlWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringWriter.toString();
    }
    /**
     * 去掉声明头的(即<?xml...?>去掉)
     * @param document
     * @param charset
     * @return
     */
    public static String documentToStringNoDeclaredHeader(Document document,String charset) {
        String xml = documentToString(document, charset);
        return xml.replaceFirst("\\s*<[^<>]+>\\s*", "");
    }
    /**
     * 解析XML为Document对象
     * @param xml 被解析的XMl
     * @return Document
     */
    public final static Element parseXml(String xml) throws DocumentException {
        StringReader sr = new StringReader(xml);
        SAXReader saxReader = new SAXReader();
        Document document;
        document = saxReader.read(sr);
        Element rootElement = document.getRootElement();
        return rootElement;
    }

    public final static String getText(Element e, String tag){
        Element _e = e.element(tag);
        if(_e != null)
            return _e.getText();
        else
            return null;
    }
    public final static String getTextTrim(Element e, String tag){
        Element _e = e.element(tag);
        if(_e != null)
            return _e.getTextTrim();
        else
            return null;
    }
    /**
     * 获取节点值.节点必须不能为空，否则抛错
     * @param parent
     * @param tag
     * @return
     */
    public final static String getTextTrimNotNull(Element parent, String tag) throws Exception {
        Element e = parent.element(tag);
        if(e == null)
            throw new Exception(parent.getName() + " -> " + tag + " 节点为空.");
        else
            return e.getTextTrim();
    }
    /**
     * 节点必须不能为空，否则抛错
     * @param parent
     * @param tag
     * @return
     */
    public final static Element elementNotNull(Element parent, String tag) throws Exception {
        Element e = parent.element(tag);
        if(e == null)
            throw new Exception(parent.getName() + " -> " + tag + " 节点为空.");
        else
            return e;
    }
}