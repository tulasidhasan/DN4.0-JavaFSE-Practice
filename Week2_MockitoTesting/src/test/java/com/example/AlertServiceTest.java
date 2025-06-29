package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AlertServiceTest {

    @Test
    public void testVoidMethodHandling() {
        Notifier mockNotifier = mock(Notifier.class);
        doNothing().when(mockNotifier).send(anyString());

        AlertService service = new AlertService(mockNotifier);
        service.triggerAlert();

        verify(mockNotifier).send("Alert!");
    }

    @Test
    public void testVoidMethodWithException() {
        Notifier mockNotifier = mock(Notifier.class);
        doThrow(new RuntimeException("Failure")).when(mockNotifier).send(anyString());

        AlertService service = new AlertService(mockNotifier);
        assertThrows(RuntimeException.class, service::triggerAlert);
    }
}
