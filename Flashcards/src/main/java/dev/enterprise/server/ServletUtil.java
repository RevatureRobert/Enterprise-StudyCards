package dev.enterprise.server;

import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * A class to utilize reflection to find and execute the proper servlet.
 *      This will utilize a json file in src/main/resources to get
 *      the application config on which servlets should be responsible
 *      for the different endpoints.
 */
public class ServletUtil {

    private static HashMap<String, String> uriMapping;



    static {
        Gson json = new Gson();
        try {
            uriMapping = json.fromJson(new FileReader(new File("src/main/resources/servlet-config.json")), HashMap.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * Given the path to the uri, find the servlet specified in the json file and return
     *      an instance of it.
     * @param uriPath
     * @return
     */
    static HttpServlet getServlet(String uriPath) {
        try {
            String fQCN = uriMapping.get(uriPath);
            Class clazz = Class.forName(fQCN);
            if(clazz.getSuperclass().equals(HttpServlet.class)){
                HttpServlet servlet = (HttpServlet) clazz.getConstructor().newInstance();
                return servlet;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Invoke the proper method on a servlet given the servlet itself, the request and response objects, and
     *      the name of the method. The name of the method is given by the enum HttpMethodNames.
     * @param servlet
     * @param req
     * @param res
     * @param name
     */
    static void invoke(HttpServlet servlet, HttpServletRequest req, HttpServletResponse res, HttpMethodNames name){
        try {
            Class clazz = servlet.getClass();
            Method m = clazz.getDeclaredMethod(name.methodName, HttpServletRequest.class, HttpServletResponse.class);
            m.setAccessible(true);

            m.invoke(servlet, req, res);




        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

}


/**
 * An enum to model the http verbs to the servlet methods.
 */
enum HttpMethodNames {
    GET("doGet"),
    POST("doPost"),
    PUT("doPut"),
    DELETE("doDelete"),
    OPTIONS("doOptions");

    String methodName;

    HttpMethodNames(String s){
        methodName = s;
    }
}