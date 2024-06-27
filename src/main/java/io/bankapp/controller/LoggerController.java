package io.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import io.bankapp.model.Logger;
import io.bankapp.service.LoggerService;
import java.util.List;

@RestController
public class LoggerController {
	@Autowired
	private LoggerService loggerService;


	// addLog
	public void addLog(Logger logger) {
		loggerService.addLog(logger);
	}

	// showLogsByAccountId
	@GetMapping("/account/{acctID}/logs")
	public List<Logger> showLogsByAccountId(@PathVariable int acctID) {
		return loggerService.showLogsByAccountId(acctID);
	}

	public void deleteLogsByAccountId(int acctID) {
		loggerService.deleteLogsByAccountId(acctID);
	}
}
