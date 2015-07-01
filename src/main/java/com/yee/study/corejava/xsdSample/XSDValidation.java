package com.yee.study.corejava.xsdSample;

import java.io.File;
import java.io.IOException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 9/4/14
 * Time: 3:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class XSDValidation
{
    public boolean Validatexml(String xsdpath, String xmlpath) throws SAXException, IOException
    {
        //建立schema工厂
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        //建立验证文档文件对象，利用此文件对象所封装的文件进行schema验证
        File schemaFile = new File(xsdpath);
        //利用schema工厂，接收验证文档文件对象生成Schema对象
        Schema schema = schemaFactory.newSchema(schemaFile);
        //通过Schema产生针对于此Schema的验证器，利用schenaFile进行验证
        Validator validator = schema.newValidator();
        //得到验证的数据源
        Source source = new StreamSource(xmlpath);
        //开始验证，成功输出success!!!，失败输出fail
        try
        {

            validator.validate(source);

        }
        catch (Exception ex)
        {

            ex.printStackTrace();

        }
        return true;
    }

    public static void main(String[] args) throws Exception
    {
        String xsdpath = System.getProperty("user.dir") + "\\src\\com\\yee\\study\\corejava\\xsdSample\\library.xsd";
        String xmlpath = System.getProperty("user.dir") + "\\src\\com\\yee\\study\\corejava\\xsdSample\\library.xml";
        new XSDValidation().Validatexml(xsdpath, xmlpath);
    }

}
