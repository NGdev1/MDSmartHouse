package com.md.smarthouse.controller.api;

import com.md.smarthouse.dao.SocketDataRepository;
import com.md.smarthouse.dto.UpdateState;
import com.md.smarthouse.model.SocketData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/socket")
public class SocketApiController {

    private final
    SocketDataRepository socketDataRepository;

    public SocketApiController(SocketDataRepository socketDataRepository) {
        this.socketDataRepository = socketDataRepository;
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public @ResponseBody
    String updateDataFromUser(@RequestBody UpdateState state) {
        SocketData socketData = socketDataRepository.getCurrent();
        socketData.setOn(state.isOn());
        socketDataRepository.setData(socketData);
        return "OK";
    }

    @RequestMapping(value = "/chip", method = RequestMethod.PUT)
    public @ResponseBody
    UpdateState updateDataFromBoiler(@RequestParam float temperatureFromSensor) {
        System.out.println("Chip calls! " + temperatureFromSensor);
        SocketData socketData = socketDataRepository.getCurrent();
        socketData.setLastTemperatureFromSensor(temperatureFromSensor);
        socketDataRepository.setData(socketData);

        return new UpdateState(socketData.isOn());
    }
}

