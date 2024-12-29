package org.example;

import org.example.utils.AppMenu;
import org.example.Interface.IConsoleHandler;
import org.example.utils.HandleOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class MainTest {

    @Mock
    private IConsoleHandler mockConsoleHandler;
    @Mock
    private AppMenu mockAppMenu;
    @Mock
    private HandleOption mockHandleOption;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test Main Method")
    void testMainMethod() {
        when(mockConsoleHandler.readLine()).thenReturn("1", "0"); // Simulate user input

        // Run the main method in a separate thread to avoid blocking
        Thread mainThread = new Thread(() -> {
            Main.keepRunning = true;
            Main.main(new String[]{});
        });
        mainThread.start();

        // Allow some time for the main method to execute
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Stop the main loop
        Main.keepRunning = false;

        // Verify interactions
        verify(mockAppMenu, atLeastOnce()).displayMenu();
        verify(mockConsoleHandler, atLeastOnce()).readLine();
        verify(mockHandleOption, atLeastOnce()).execute(anyInt());
    }
}