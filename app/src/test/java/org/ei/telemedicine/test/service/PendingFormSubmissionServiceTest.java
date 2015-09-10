package org.ei.telemedicine.test.service;

import android.test.AndroidTestCase;

import org.ei.telemedicine.repository.FormDataRepository;
import org.ei.telemedicine.service.PendingFormSubmissionService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class PendingFormSubmissionServiceTest extends AndroidTestCase {
    @Mock
    private FormDataRepository repository;
    private PendingFormSubmissionService pendingFormSubmissionService;

    @Before
    public void setUp() {
        initMocks(this);
        pendingFormSubmissionService = new PendingFormSubmissionService(repository);
    }

    @Test
    public void testShouldFetchPendingFormSubmissionCount() {
        pendingFormSubmissionService.pendingFormSubmissionCount();

        verify(repository).getPendingFormSubmissionsCount();
    }
}
