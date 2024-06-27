package io.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.bankapp.dao.LoggerRepository;
import io.bankapp.model.Logger;
import java.util.List;

@Service
public class LoggerService {
	@Autowired
	private LoggerRepository loggerRepository;

	public void addLog(Logger logger) {
		loggerRepository.save(logger);
	}

	public List<Logger> showLogsByAccountId(int acctID) {
		return loggerRepository.findByAcctID(acctID);
	}

	public void deleteLogsByAccountId(int acctID) {
		loggerRepository.deleteByAcctID(acctID); // Deleting logs by account ID
	}
}
