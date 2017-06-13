package imserver;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class OpenImServer extends Thread implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		OpenImServer ois = new OpenImServer();
		ois.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		new ServerListen().begin();
	}
}
