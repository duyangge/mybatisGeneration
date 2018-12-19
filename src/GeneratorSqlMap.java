
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.chainsaw.Main;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 *<p>Title:  GeneratorSqlMap.java</p>
 *<p>Description:  实现逆向工程（）</p>
 * @package   mybatisGenerator
 * @author    黄信胜
 * @date      2018年12月6日下午11:34:35
 * @version 1.0
 */
@SuppressWarnings("all")
public class GeneratorSqlMap {
	
	@Test
	public void generator() {
		
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
	   String pathName="src/generatorConfig.xml";
		File configFile = new File(pathName);
		//ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		//InputStream configFile = classloader.getResourceAsStream("generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config;
		try {
			config = cp.parseConfiguration(configFile);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator	myBatisGenerator = new MyBatisGenerator(config,callback,warnings);
			myBatisGenerator.generate(null);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XMLParserException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
		
	}
	
}
