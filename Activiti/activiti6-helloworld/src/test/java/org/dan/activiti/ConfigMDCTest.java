package org.dan.activiti;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.dan.activiti.helloworld.DemoMain;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;

public class ConfigMDCTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigMDCTest.class);
	
	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();

	@Test
	@Deployment(resources = {"org/dan/activiti/process.bpmn20.xml"})
	public void test() {
		ProcessInstance processInstance = activitiRule.getRuntimeService().startProcessInstanceById("process");
		assertNotNull(processInstance);
		
		Task task = activitiRule.getTaskService().createTaskQuery().singleResult();
		assertEquals("User Task", task.getName());
		
	}
}
