package com.intuit.developer.sampleapp.crud.entities.timeactivity;

import java.text.ParseException;
import java.util.List;

import com.intuit.developer.sampleapp.crud.helper.TimeActivityHelper;
import com.intuit.developer.sampleapp.crud.qbo.DataServiceFactory;
import com.intuit.ipp.data.TimeActivity;
import com.intuit.ipp.data.Error;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.services.DataService;
import com.intuit.ipp.util.Logger;

/**
 * Demonstrates methods to delete timeactivity data
 * Note: We'll create an entity first and then delete the same
 * 
 * @author dderose
 *
 */
public class TimeActivityDelete {

	private static final org.slf4j.Logger LOG = Logger.getLogger();
	
	public static void main(String[] args) {
		try {
			deleteTimeActivity();
		} catch (Exception e) {
			LOG.error("Error during CRUD", e.getCause());
		}
	}
	
	public static void deleteTimeActivity() throws FMSException, ParseException {
		
		try {
			DataService service = DataServiceFactory.getDataService();
			
			// create timeactivity
			TimeActivity timeactivity = TimeActivityHelper.getTimeActivityFields(service);
			TimeActivity addTimeActivity = service.add(timeactivity);
			LOG.info("TimeActivity added : " + addTimeActivity.getId());

			//delete timeactivity
			TimeActivity deletedTimeActivity = service.delete(addTimeActivity);		
			LOG.info("TimeActivity deleted : " + deletedTimeActivity.getId() + " status ::: " + deletedTimeActivity.getStatus());
			
		} catch (FMSException e) {
			List<Error> list = e.getErrorList();
			list.forEach(error -> LOG.error("Error while deleting entity :: " + error.getMessage()));
		}
		
	}
}
