package top.fxxxx.InformationPortal.Util;

import org.dom4j.Element;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ConfigProvider {
    private static Element root;
    private static long lastModified=-1;
    private static File config;
    //获取指定元素
    public static Element getConfig(String ConfigName){
        return getRoot().element(ConfigName);
    }
    //获取xml根元素
    public static Element getRoot(){
        if(isModified()){
            synchronized (ConfigProvider.class){
                if(isModified()){
                    FastInputReader in=null;
                    try {
                        lastModified=getConfigFile().lastModified();
                        in = new FastInputReader(new FileInputStream(config));
                        root=XmlUtils.parseXml(in.getAll());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        if(in!=null) {
                            try {
                                in.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return root;
    }
    //是否被修改
    public static boolean isModified(){
        return lastModified!=getConfigFile().lastModified();
    }
    //获取配置文件
    private static File getConfigFile(){
        if(config==null) {
            synchronized (ConfigProvider.class) {
                if(config==null) {
                    config=ConfigFile();
                }
            }
        }
        return config;
    }
    /**
     * 获取配置文件，可按实际需求更改
     * @return 配置文件
     */
    private static File ConfigFile(){
        String confDir = null;
        confDir = ConfigProvider.class.getResource("/..").getPath()+ File.separator;

        return new File(confDir+"Config.xml");
    }
}
