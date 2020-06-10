package com.karang.taruna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karang.taruna.models.Status;
import com.karang.taruna.service.StatusService;

@RestController
@RequestMapping("status")
public class UserStatusController {

	@Autowired
	StatusService statusService;

	@PutMapping("{idStatus}")		
	public Status updateStatus(@RequestBody Status status,@PathVariable String idStatus) {
		return statusService.updateStatus(status, idStatus);
	}
}
