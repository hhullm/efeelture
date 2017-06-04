package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author zs
 *
 *         数据库连接
 */
public class DBUtil {
	private static String url;
	private static String user;
	private static String pwd;
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	static {
		try {
			Properties prop = new Properties();
			InputStream is = DBUtil.class.getClassLoader().getResourceAsStream(
					"utils/config.properties");

			prop.load(is);
			is.close();
			String driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			pwd = prop.getProperty("pwd");

			Class.forName(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {
		try {
			Connection conn = DriverManager.getConnection(url, user, pwd);
			tl.set(conn);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void close(Connection conn) {
		try {
			conn = tl.get();
			if (conn != null) {
				conn.close();
				tl.remove();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
