package springmvc.rootconfig;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoCredential;

@Configuration
// 启用MongoDB的Repository功能
@EnableMongoRepositories(basePackages = "springmvc.orders.db")	
public class MongoConfig {
	@Autowired
	private Environment env;
	// MongoClient配置
	@Bean
	public MongoClientFactoryBean mongo() {
		MongoClientFactoryBean mongo = new MongoClientFactoryBean();
		mongo.setHost("localhost");
//		MongoCredential credential=MongoCredential.createCredential(env.getProperty("mongo.username"), "OrdersDB",env.getProperty("mongo.password").toCharArray());
//		mongo.setCredentials(new MongoCredential[]{credential});
		return mongo;
	}

	// Mongo Template配置
	@Bean
	public MongoOperations mongoTemplate(Mongo mongo) {
		return new MongoTemplate(mongo, "OrdersDB");
	}
}
