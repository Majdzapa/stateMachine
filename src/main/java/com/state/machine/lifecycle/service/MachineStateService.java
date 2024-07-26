package com.state.machine.lifecycle.service;

import com.state.machine.lifecycle.state.MachineEvent;
import com.state.machine.lifecycle.state.MachineState;
import com.state.machine.lifecycle.state.StateMachineExample;
import org.springframework.stereotype.Service;

@Service
public class MachineStateService {

    public MachineState getNextStateBasedOnEvent(MachineEvent event , MachineState state){

        StateMachineExample stateMachine = StateMachineExample.getInstance();

        return stateMachine.getNextState(state,event);
    }
}
