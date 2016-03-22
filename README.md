Utility soft for JDBC connectivity to HIVE

Quick start guide :

1. Check out a repo : 

$git clone https://github.com/hupuxiaojun/hiveutil.git

2. Compile :

$cd hiveutil
$mvn clean install

3. Run your code

$cd target 

If you would like to redirect output to STDOUT :

java  -Dhue_user=hdfs -Dhue_password=hdfs -jar hiveutil-1.0-SNAPSHOT-jar-with-dependencies.jar  "n1" "show tables"

If you would like to redirect output to a file 

java  -Dhue_user=hdfs -Dhue_password=hdfs -jar hiveutil-1.0-SNAPSHOT-jar-with-dependencies.jar  "n1" "show tables" "/tmp/result.txt"



