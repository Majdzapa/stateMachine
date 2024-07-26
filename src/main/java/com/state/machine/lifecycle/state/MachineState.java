package com.state.machine.lifecycle.state;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum MachineState {

    STARTED("start"),
    STATE1("state1"),
    STATE2("state2"),
    CANCELLED("cancel"),//final sate
    ENDED("end") // final state
    ;

    private final String value;

    public static MachineState fromValue(String name){

        return Arrays.stream(MachineState.values())
                .filter( ms -> ms.getValue().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No State found with this name :" + name));
    }


}
