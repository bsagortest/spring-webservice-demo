package com.rufaida.controller.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rufaida.domain.test.TestEntity;
import com.rufaida.service.Database;

@Controller
public class TestController {
	
	@RequestMapping("/rufaida")
    @ResponseBody
	 public HashMap<String, Object> selectAll()
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<TestEntity> testEntities = new ArrayList<TestEntity>();

        String sql = "select " +
						"t_sex_code, t_lang2_name " +
        			"from " + 
        				"t02006";
        			
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 TestEntity entity = new TestEntity();
            		 entity.setA(resultSet.getString("t_sex_code"));
            		 entity.setB(resultSet.getString("t_lang2_name"));
            		 
            		 testEntities.add(entity);
    			 }
             }else{
            	 System.out.println("not found");
             }
             
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement!=null){
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
         
         if(testEntities != null){
        	 plr.put("data", testEntities);
         }
         
         return plr;
     }
}
