javac berkeley/*.java
rmic berkeley.BerkeleyImpl
rmiregistry

java -Djava.security.policy=berkeley/policy berkeley.BerkeleyImpl
java -Djava.security.policy=berkeley/policy berkeley.BerkeleyClient localhost


javac Chat.java Main.java MessageReceiver.java && rmic Chat
java -Djava.rmi.server.codebase=file:$(pwd)/ -Djava.security.policy=policy Main $@
