package za.ac.nwu.ac.logic.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.ac.logic.config.TranslatorConfig;

@Import({TranslatorConfig.class})
@Configuration
public class LogicConfig {
}
