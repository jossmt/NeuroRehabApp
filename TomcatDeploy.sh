gradle clean war
cd /usr/local/Tomcat/bin
sh shutdown.sh
mv ~/Documents/neurorehabapp/controller/build/libs/neurorehabapp.war /usr/local/Tomcat/webapps/
cd /usr/local/Tomcat/bin
sh startup.sh
