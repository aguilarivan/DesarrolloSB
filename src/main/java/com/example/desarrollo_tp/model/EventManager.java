package com.example.desarrollo_tp.model;

import java.util.ArrayList;
import java.util.List;

public abstract class EventManager{
    // Atributos ------------------------------------------------------------------------------------------------------------------------------------

    private List<EventListener> listeners = new ArrayList<>();

    // Methods --------------------------------------------------------------------------------------------------------------------------------------
    public EventManager(){
        this.listeners = new ArrayList<>();
    }
    public void addEventListener(EventListener listener){
        this.listeners.add(listener);
    }
    public void notifyListeners(Pedido p){
        for (EventListener l : listeners) {
            l.update(p);
        }
    }

}