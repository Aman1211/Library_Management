package library.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Util {
	public static Object createObject(String class_name) {
		Object obj = null;
		try {
			Class name = Class.forName(class_name);
			obj = name.newInstance();
		} catch (Exception e) {
			System.err.println("Error");
		}
		return obj;
	}
}