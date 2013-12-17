package net.tomoyamkung.sample;

import org.springframework.boot.SpringApplication;

/**
 * アプリケーション実行クラス。
 * 
 * Web アプリケーションに組み込まずに <code>CronScheduledTask</code> をバックグラウンドで実行する。
 * 
 * @author tomoyamkung
 *
 */
public class App {

	/**
	 * <code>CronScheduledTask</code> を実行する。
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		SpringApplication.run(CronScheduledTask.class);
	}
}
