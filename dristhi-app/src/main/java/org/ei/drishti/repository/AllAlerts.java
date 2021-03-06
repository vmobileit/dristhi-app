package org.ei.drishti.repository;

public class AllAlerts {
    private AlertRepository repository;

    public AllAlerts(AlertRepository repository) {
        this.repository = repository;
    }

    public void changeAlertStatusToInProcess(String entityId, String alertName) {
        repository.changeAlertStatusToInProcess(entityId, alertName);
    }
}
