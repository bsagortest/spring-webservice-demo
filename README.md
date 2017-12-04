# spring-webservice-demo
This is a demo project for webservice.
Oracle database is integrated in this project.
Maven Install:
To install the Oracle jdbc drivers :
    # ojdbc6.jar:
    	$ mvn install:install-file -Dfile={Path/to/your/ojdbc6.jar}
          	-DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar
    # ojdbc7.jar:
    	$ mvn install:install-file -Dfile={Path/to/your/ojdbc7.jar}
      		-DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0 -Dpackaging=jar
      
# Just add your oracle jar and edit Database.java class
    public Connection getConnection() {
    	Connection connection = null;
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@100.43.0.16:1521:oracle", "user","password"); // Local
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return connection;
    }
    
# Now go to TestController.java class and change the sql query as yours.
    String sql = "select " +
					"t_sex_code, t_lang2_name " +
        			"from " + 
        				"t02006";
                
    if(resultSet!=null){
            	 while (resultSet.next()) {
            		 TestEntity entity = new TestEntity();
            		 entity.setA(resultSet.getString("t_sex_code"));
            		 entity.setB(resultSet.getString("t_lang2_name"));
            		 
            		 testEntities.add(entity);
    			 }
             }
                
# Now compile and run the project and use the url: http://localhost:9010/rufaida
# If you want to change the port, go to application.properties
  server.port=9010
