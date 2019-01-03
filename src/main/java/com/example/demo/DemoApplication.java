package com.example.demo;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer implements CommandLineRunner {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		String sql = "select t.* from user_userinfo t where rownum < 10";
		List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
		for (Map<String,Object> map : list){
			System.out.println(map.get("userid"));
		}
	}
}

