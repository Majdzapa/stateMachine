package com.state.machine.lifecycle.common;

import com.state.machine.lifecycle.exception.FinalStateException;
import com.state.machine.lifecycle.exception.NotFoundStateException;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@SuperBuilder
@Slf4j
@Getter
public abstract class AbstractStateMachine<S,E> {

    @Singular("transition")
    private final List<Transition<S,E>> transition;
    @Singular("finalState")
    private final List<S> finalState;

    public S getNextState (S from, E onEvent){

        final boolean isFinalState = Optional.ofNullable(finalState)
                .filter( states -> states.contains(from))
                .isPresent();

        if (isFinalState){

             throw new FinalStateException();
        }

      Transition<S,E> result =  transition.stream()
                .filter(t -> t.getFrom() == from)
                .filter(t -> t.getOnEvent() == onEvent)
                .findFirst()
                .orElseThrow(() ->
                        new NotFoundStateException(
                        String.format("No transition define from state %s on event %s"
                        ,from , onEvent)));

        return result.getTo();
    }


    @Value
    @Builder
    protected static class Transition<S,E>{
         S from;
         S to;
         E onEvent;
    }
}
