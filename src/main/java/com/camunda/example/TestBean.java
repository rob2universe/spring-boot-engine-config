package com.camunda.example;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.springframework.stereotype.Component;

@Component
public class TestBean implements JavaDelegate {

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    Customer customer = new Customer();

    customer.setName("Horst");
    ObjectValue customerJson = Variables
        .objectValue(customer)
        .serializationDataFormat(Variables.SerializationDataFormats.JSON)
        .create();
    execution.setVariable("customer", customerJson);


  }
}
