# AMQ-Standalone-Client-Consumer
Standalone Java Client and Consumer for quick/dirty AMQ testing. This is not meant to be used as a quickstart as it doesn't show anything useful.
However, if you need a quick Java client to test a AMQ server install to ensure connection/messages and logs are being created correctly then this might be useful.

This repo provides 2 classes
 - AMQJMSClient.java
 - AMQJMSConsumer.java

Steps to run
Clone this repo and import in to your favourite IDE
You need classpath set up as per http://activemq.apache.org/initial-configuration.html
Download AMQ from https://www.jboss.org/products/amq/overview/
Unzip and go to /bin directory and run .amq script. You'll see an output like below

[mmusaji@mmusaji bin]$ ./amq
karaf: JAVA_HOME not set; results may vary
Please wait, JBoss A-MQ is initializing...
100% [========================================================================]

      _ ____                                __  __  ____
     | |  _ \                    /\        |  \/  |/ __ \
     | | |_) | ___  ___ ___     /  \ ______| \  / | |  | |
 _   | |  _ < / _ \/ __/ __|   / /\ \______| |\/| | |  | |
| |__| | |_) | (_) \__ \__ \  / ____ \     | |  | | |__| |
 \____/|____/ \___/|___/___/ /_/    \_\    |_|  |_|\___\_\

  JBoss A-MQ (6.2.1.redhat-084)
  http://www.redhat.com/products/jbossenterprisemiddleware/amq/

Hit '<tab>' for a list of available commands
and '[cmd] --help' for help on a specific command.

Open a browser to http://localhost:8181 to access the management console

Hit '<ctrl-d>' or 'osgi:shutdown' to shutdown JBoss A-MQ.

JBossA-MQ:karaf@root>

Then run the consumer and the client classes. Job Done.
