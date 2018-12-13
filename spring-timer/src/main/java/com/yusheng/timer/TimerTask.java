package com.yusheng.timer;





import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/***
 * 定时任务
 * @author XuSheng
 *
 */
@Component
public class TimerTask {
	
	public Logger logger = Logger.getLogger(this.getClass());
	// 将bean中的值注入
	@Value("#{sync_quartz}")
	private Properties quartzConf;
	

	@Scheduled(cron = "${timer.task}")
	public void timerMethod() {
		if("ON".equals(quartzConf.getProperty("timer.status"))) {
			SimpleDateFormat  sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println("定时任务执行------------------"+sf.format(new Date()));
		}else {
			System.out.println("定时任务处于关闭状态------------");
		}

	}
}
