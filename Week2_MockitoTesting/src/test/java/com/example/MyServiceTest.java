package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InOrder;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testMockingAndStubbing() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();

        verify(mockApi).getData();
    }

    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("First").thenReturn("Second");

        MyService service = new MyService(mockApi);

        assertEquals("First", service.fetchData());
        assertEquals("Second", service.fetchData());
    }

    @Test
    public void testInteractionOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();

        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).getData();
        
    }
}
