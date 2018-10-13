package org.dan.activiti.config;

import org.activiti.engine.ProcessEngineConfiguration;
import org.dan.activiti.DemoMain;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试
 * @author: Gordan Lin
 * @create: 2018/9/7
 **/
public class ConfigTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoMain.class);

    @Test
    public void testConfig1() {
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResourceDefault();

        LOGGER.info("configuration = {}", configuration);
    }

    @Test
    public void testConfig2() {
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration
                .createStandaloneProcessEngineConfiguration();
        LOGGER.info("configuration = {}", configuration);
    }

}
