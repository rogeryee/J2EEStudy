package com.yee.study.utilites.timeout;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: RogerYee
 * <p/>
 * 用于扫描指定的Java类，分析出其中标有@Timeout的方法，并生成代理类
 * <p/>
 * 本例中扫描的路径为classpath＋"/"+subClassPath，
 * 即扫描System.getProperty("user.dir") + "/web/WEB-INF/classes/com/yee/study/utilites/timeout" 目录下的所有.class文件。
 */
public class TimeoutMethodScanner
{
    // 扫描的结果
    private static Map<String, List<TimeoutMethod>> map = new HashMap<String, List<TimeoutMethod>>();

    // 指定扫描的CLASSPATH
    private static String classpath = System.getProperty("user.dir") + "/web/WEB-INF/classes";

    // 指定扫描的子路径，如果没有则表示扫描classpath下的所有类
    private static String subClassPath = "com/yee/study/utilites/timeout";

    static
    {
        scan();
    }

    private static void scan()
    {
        File file = new File(classpath + "/" + subClassPath);
        getAll(file);
    }

    private static void getAll(File file)
    {
        if (!file.isDirectory())
        {
            if (file.getName().endsWith("class"))
            {
                String pkg = file.getAbsolutePath();
                String substring = classpath + "/";

                pkg = pkg.substring(pkg.indexOf(substring) + substring.length());
                pkg = pkg.replaceAll("/", ".");
                pkg = pkg.replaceAll(".class", "");

                if (!map.containsKey(pkg))
                {
                    createInstance(pkg);
                }
            }
        }
        else
        {
            File[] files = file.listFiles();
            for (File f : files)
            {
                getAll(f);
            }
        }
    }

    private static void createInstance(String pkg)
    {
        try
        {
            Class<?> cls = Class.forName(pkg);

            Method[] m = cls.getMethods();
            List<TimeoutMethod> list = new ArrayList<TimeoutMethod>();
            for (Method method : m)
            {

                if (method.isAnnotationPresent(Timeout.class))
                {
                    Timeout timeout = (Timeout) method.getAnnotation(Timeout.class);
                    TimeoutMethod timeoutMethod = new TimeoutMethod();
                    timeoutMethod.setTimeout(timeout);
                    timeoutMethod.setObject(cls);
                    timeoutMethod.setMethod(method);
                    list.add(timeoutMethod);

                }
            }
            if (list.size() > 0)
            {
                map.put(pkg, list);
            }
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static List<TimeoutMethod> getTimeoutMethods(String key){
        return map.get(key);
    }
}
