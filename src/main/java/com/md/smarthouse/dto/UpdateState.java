package com.md.smarthouse.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateState {
    private boolean isOn;

    public UpdateState() {}
    public UpdateState(boolean isOn) {
        this.isOn = isOn;
    }
}
