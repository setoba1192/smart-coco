package co.com.coco.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Config {

	
	/**
	 * Configurar datasource 
	 * 
	 * @return datasource
	 * 
	 */
	/*
	@Bean
	public DataSource getDataSource() throws NamingException {
		return (DataSource) new JndiTemplate().lookup(Parametros.datasource);
	}
	*/

	@Bean
	public Mapper mapper(@Value(value = "classpath*:mappings/*mappings.xml") Resource[] resourceArray)
			throws IOException {
		List<String> mappingFileUrlList = new ArrayList<>();
		for (Resource resource : resourceArray) {
			mappingFileUrlList.add(String.valueOf(resource.getURL()));
		}
		DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
		dozerBeanMapper.setMappingFiles(mappingFileUrlList);
		return dozerBeanMapper;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

		messageSource.setBasename("classpath:i18n/messages");
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

}
