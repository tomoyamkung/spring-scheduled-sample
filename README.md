spring-scheduled-sample
=======================

# spring-scheduled-sample とは

Web アプリで定期的な処理を実行する仕組みというと [s2chronos](http://s2chronos.sandbox.seasar.org/ja/) ぐらいしか知らなかったのですが、[Spring](http://spring.io/) でも定期実行する仕組みがあるようなので、それを試すサンプルプログラムです。


# 開発環境

spring-scheduled-sample は以下の環境で開発しました。

```sh
java -version
java version "1.6.0_37"
Java(TM) SE Runtime Environment (build 1.6.0_37-b06)
Java HotSpot(TM) 64-Bit Server VM (build 20.12-b01, mixed mode)
```

JVM のバージョンが 1.6 なのは仕事都合です。。。


```sh
mvn -v
:
Apache Maven 3.0.4 (r1232337; 2012-01-17 17:44:56+0900)
:
:
```

プロジェクトは [Apache Maven](http://maven.apache.org/) を使ってビルドしています。バージョンは 3.0.4 です。


# 動作方法

まずは、このプロジェクトを clone してください。

```sh
git clone https://github.com/tomoyamkung/spring-scheduled-sample.git
```

プロジェクトに移動しビルドします。

```sh
cd spring-scheduled-sample
mvn clean package
```

バージョン 4.0.0 のライブラリや spring-boot-starter がローカルリポジトリに存在しない場合は大量のライブラリが降ってきます。。。

ビルドが成功したらアプリケーションを動かしてみます。
1分間隔で現在時刻が標準出力に出力されます。


```sh
java -jar target/spring-scheduled-sample.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::             (v0.5.0.M6)

:
:
:

2013/12/17 19:18:00
2013/12/17 19:19:00
2013/12/17 19:20:00

:
```

Ctrl+C でアプリケーションは停止します。


# 参照プログラム

spring-scheduled-sample は次のチュートリアルを元に作成しました。

- [Getting Started · Scheduling Tasks](http://spring.io/guides/gs/scheduling-tasks/)

「元に」というかほぼパクリですが、参照元との違いは次の通りです。

- fixedRate を使った定期実行ではなく cron を使った定期実行


# @Scheduled アノテーションについて

- [27. Task Execution and Scheduling](http://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/scheduling.html#scheduling-annotation-support-scheduled)

@Scheduled アノテーションは次の4通りの方法で定期実行をスケジュールできるようになっています。

- fixedDelay: 前回の実行が終了後、指定したインターバルだけ処理を停止して次の処理を実行する
- fixedRate: 指定したインターバルで実行する
- initialDelay + fixedRate: 指定したインターバルで実行する。初回の実行を initialDelay で指定した時間だけ遅らせる
- cron: cron 形式で指定する

"cron" で指定する場合、設定値は左から次のようになっています。

- 秒
- 分
- 時
- 日
- 月
- 曜日

