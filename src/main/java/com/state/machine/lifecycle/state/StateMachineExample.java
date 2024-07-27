package com.state.machine.lifecycle.state;

import com.state.machine.lifecycle.common.AbstractStateMachine;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@SuperBuilder
@Slf4j
public class StateMachineExample extends AbstractStateMachine<MachineState,MachineEvent> {

    private static final StateMachineExample INSTANCE = StateMachineExample.builder()

            .transition(Transition.<MachineState,MachineEvent>builder()
                    .from(MachineState.STARTED)
                    .onEvent(MachineEvent.STATE1_EVENT)
                    .to(MachineState.STATE1)
                    .build())

            .transition(Transition.<MachineState,MachineEvent>builder()
                    .from(MachineState.STATE1)
                    .onEvent(MachineEvent.STATE2_EVENT)
                    .to(MachineState.STATE2)
                    .build())

            .transition(Transition.<MachineState,MachineEvent>builder()
                    .from(MachineState.STATE2)
                    .onEvent(MachineEvent.CANCEL_EVENT)
                    .to(MachineState.CANCELLED)
                    .build())

            .transition(Transition.<MachineState,MachineEvent>builder()
                    .from(MachineState.STATE2)
                    .onEvent(MachineEvent.END_EVENT)
                    .to(MachineState.ENDED)
                    .build())

            .finalState(MachineState.ENDED)
            .finalState(MachineState.CANCELLED)

            .build();

    public static StateMachineExample getInstance(){return INSTANCE;}

    private static List<MachineState> finalStates(){
       return getInstance().getFinalState();
    }
}