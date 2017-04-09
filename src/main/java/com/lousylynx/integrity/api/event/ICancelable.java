package com.lousylynx.integrity.api.event;

import lombok.Getter;
import lombok.Setter;

public abstract class ICancelable extends IEvent {

    @Getter
    @Setter
    public boolean canceled = false;
}
