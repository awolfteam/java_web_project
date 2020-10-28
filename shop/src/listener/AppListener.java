package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import tools.C3P0Utils;

public class AppListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
				
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//服务器启动时初始化数据库连接
		C3P0Utils.getDataSource();
		
	}

}
