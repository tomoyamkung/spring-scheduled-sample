package net.tomoyamkung.sample;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定期的に実行する処理を持ったタスククラス。
 * 
 * @author tomoyamkung
 *
 */
@EnableScheduling
public class CronScheduledTask {

    /**
     * 日付フォーマット。
     */
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    /**
     * 現在時刻を1分ごとに標準出力に出力する。
     */
    @Scheduled(cron = "0 */1 * * * *")
    public void printCurrentTime() {
        System.out.println(dateFormat.format(new Date()));
    }
    
}
