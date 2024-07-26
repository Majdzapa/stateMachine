package com.state.machine.lifecycle.service;

import com.state.machine.lifecycle.exception.FinalStateException;
import com.state.machine.lifecycle.exception.NotFoundStateException;
import com.state.machine.lifecycle.state.MachineEvent;
import com.state.machine.lifecycle.state.MachineState;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class MachineStateServiceTest {

    @InjectMocks
    private MachineStateService service;
    @Test
    void getNextStateBasedOnEvent() {

        MachineState result = service.getNextStateBasedOnEvent(
                MachineEvent.STATE1_EVENT,
                MachineState.STARTED
        );

        assertEquals(MachineState.STATE1.getValue(),result.getValue());

    }


    @Test
    void getNextStateBasedOnEvent_WHEN_not_exist_THEN_NotFoundStateException() {

        assertThrows(NotFoundStateException.class , () -> service.getNextStateBasedOnEvent(
                MachineEvent.STATE1_EVENT,
                MachineState.STATE2
        ));

    }

    @Test
    void getNextStateBasedOnEvent_WHEN_final_state_THEN_FinalStateException() {

        assertThrows(FinalStateException.class , () -> service.getNextStateBasedOnEvent(
                MachineEvent.STATE1_EVENT,
                MachineState.CANCELLED
        ));
    }
}