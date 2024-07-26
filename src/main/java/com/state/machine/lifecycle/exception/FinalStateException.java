package com.state.machine.lifecycle.exception;

public class FinalStateException extends RuntimeException{

    public FinalStateException(){
        super("Final state is reached!");
    }
}
