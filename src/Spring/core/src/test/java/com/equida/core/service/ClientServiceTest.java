package com.equida.core.service;

import com.equida.ApplicationTest;
import com.equida.common.bdd.entity.Client;
import com.equida.common.exception.NotFoudException;
import com.equida.common.service.ClientService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationTest.class)
public class ClientServiceTest {
	
	@Autowired
	private ClientService clientService;
	
	@Test(expected = NotFoudException.class)
	public void test_getById_NotFoundException_ko() {
		clientService.getById(-5L);
	}
	
	@Test
	public void test_getById_ok() {
		Client client = clientService.getById(1L);
		
		Assert.assertEquals("Deltour", client.getNom());
	}
	
}
